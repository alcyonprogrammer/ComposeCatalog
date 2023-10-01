package com.alcyonstudio.jetpackcomposecatalogo.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

//    val snackBarHostState = remember { SnackbarHostState() }
//    val coroutineScope = rememberCoroutineScope()
//
//    Scaffold(
//        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
//        topBar = { MyTopAppBar { coroutineScope.launch { snackBarHostState.showSnackbar("Has pulsado $it") } } },
//         bottomBar = { MyBottomNavigation() },
//        floatingActionButton = { MyFAB() },
//        floatingActionButtonPosition = FabPosition.Center
//
//    ) {
//    }
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    NavigationBar(contentColor = MaterialTheme.colorScheme.primary) {

        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            label = { Text(text = "Home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            })

        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            label = { Text(text = "Favorite") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorite"
                )
            })

        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            label = { Text(text = "Search") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            })

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldExample() {
    val snackbarState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                MyModalDrawer(){                //Este es igual que hizo Aris ;D
                    scope.launch {
                        drawerState.close()
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onClickIcon = {
                        scope.launch {
                            snackbarState.showSnackbar("Has pulsado $it")
                        }
                    },
                    onClickDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            snackbarHost = { SnackbarHost(snackbarState) },
            bottomBar = {
                MyBottomNavigation()
            },
            floatingActionButton = {
                MyFAB()
            },
            floatingActionButtonPosition = FabPosition.End,
        ) { contentPadding ->
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Red)
                    .padding(contentPadding)
            )
        }
    }
}
@Composable
fun MyModalDrawer(onCloseDrawer: ()->Unit){
    Column(Modifier.padding(8.dp)) {
        Text(text = "Primera opcion", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Primera opcion", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Primera opcion", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Primera opcion", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Primera opcion", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
    }
}
@Composable
fun MyFAB() {
    FloatingActionButton(onClick = { }, modifier = Modifier
        .offset(y = 88.dp)
        .size(100.dp)) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Job,
                onClickDrawer: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = "Compose catalog",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(
                onClick = { onClickDrawer() }, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White
                )
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(
                onClick = { onClickIcon("buscar") }, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White
                )
            ) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Back")
            }
            IconButton(
                onClick = { onClickIcon("peligro") }, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White
                )
            ) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Back")
            }
        }
    )

}