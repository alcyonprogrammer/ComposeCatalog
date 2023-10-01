package com.alcyonstudio.jetpackcomposecatalogo.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcyonstudio.jetpackcomposecatalogo.R
import com.alcyonstudio.jetpackcomposecatalogo.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleReciclerView() {
    val myList = listOf("Hector", "Jose", "Hugo", "Ariel")
    LazyColumn {
        item { Text(text = "Titulo") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Alumno: $it")
        }
        item { Text(text = "Footer") }

    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current

    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
        items(getSuperHeroes().size) { index ->
            ItemHero(superhero = getSuperHeroes()[index]) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun NamesGrid(names: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2) // Using 2 columns here
    ) {
        items(names.size) { index ->
            NameItem(names[index])
        }
    }
}

@Composable
fun NameItem(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNamesGrid() {
    val sampleNames = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank")
    NamesGrid(sampleNames)
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superheros: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }

    superheros.forEach { (publisher, mySuperHero) ->

//        stickyHeader {
//        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(mySuperHero) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroWithSpecialControls() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {

//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//        items(getSuperHeroes()) { superhero ->
//            ItemHero(superhero = superhero) {
//                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }


        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            ) {
                Text(text = "Un boton cool")
            }
        }

    }
}

@Composable
fun ItemHero(superhero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
//        .width(200.dp)
        .padding(vertical = 8.dp, horizontal = 16.dp)
        .clickable { onItemSelected(superhero) }) {
        Image(
            painter = painterResource(id = superhero.photo),
            contentDescription = "Super Hero Avatar",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = superhero.superHeroName,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = superhero.realName,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 12.sp
        )
        Text(
            text = superhero.publisher,
            modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp),
            fontSize = 10.sp
        )
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlet", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wane", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garric", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),

//        SuperHero("", "", "DC", R.drawable.),
//        SuperHero("", "", "Marvel", R.drawable.),
    )
}