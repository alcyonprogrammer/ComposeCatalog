package com.alcyonstudio.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alcyonstudio.jetpackcomposecatalogo.model.Routes
import com.alcyonstudio.jetpackcomposecatalogo.ui.CheckInfo
import com.alcyonstudio.jetpackcomposecatalogo.ui.components.Screen1
import com.alcyonstudio.jetpackcomposecatalogo.ui.components.Screen2
import com.alcyonstudio.jetpackcomposecatalogo.ui.components.Screen3
import com.alcyonstudio.jetpackcomposecatalogo.ui.components.Screen4
import com.alcyonstudio.jetpackcomposecatalogo.ui.components.Screen5
import com.alcyonstudio.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            DefaultPreview()
            JetpackComposeCatalogoTheme {
//                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    var selected by remember {
                        mutableStateOf("Aris")
                    }

                    var status by rememberSaveable { mutableStateOf(false) }
                    val checkInfo = CheckInfo(title = "titulo1",
                        selected = status,
                        onCheckedChange = { myNewStatus -> status = myNewStatus })
                    val myOptions =
                        getOptions(titles = listOf("Hector", "Tzilacatzin", "Olmecas", "Mayas"))
                    Column() {
//                        myRadioButtonList(selected ){selected = it}
//                        myRadioButton()
//                        myTriStatus()
//                        myOptions.map { MyCheckBoxWithTextCompleted(it) }
//                        MyCheckBoxWithTextCompleted(checkInfo)
//                        MyCheckBoxWithText()
//                        myCard()
//                        myBadgedBox()
//                        myDivider()
//                        myDropDownMenu()
//                        MyDropDownMenu1()
//                        BasicSlider()
//                        AdvanceSlider()
//                        MyRangeSlider()
                        var shown by remember {
                            mutableStateOf(false)
                        }

//                        MyDialog(
//                            shown,
//                            onDismiss = { shown = false },
//                            onConfirm = { Log.i("confirmado", "click")})
//                        MySimpleCustomDialog(                            shown,
//                            onDismiss = { shown = false })
//                        MyCustomDialog(shown,
//                            onDismiss = { shown = false })

//                        SimpleReciclerView()
//                        SuperHeroView()
//                        SuperHeroGridView()
//                        SuperHeroWithSpecialControls()
//                        SuperHeroStickyView()
//                        ScaffoldExample()
//                        MyScaffoldExample()
//                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
//                            Button(onClick = { shown = true }) {
//                                Text(text = "Mostrar dialogo")
//                            }
//                        }
//                        MyConfirmationDialog(shown,
//                            onDismiss = { shown = false })
                        val navigationController = rememberNavController()
                        NavHost(navController = navigationController, startDestination = Routes.Screen1.route){
                            composable(Routes.Screen1.route){Screen1(navigationController)}
                            composable(Routes.Screen2.route){Screen2(navigationController)}
                            composable(Routes.Screen3.route){ Screen3(navigationController) }
                            composable(Routes.Screen4.route, arguments = listOf(
                                navArgument("name"){type = NavType.StringType}
                            )){ backStackEntry ->
                                val name :String =  backStackEntry.arguments?.getString("name").orEmpty()
                                Screen4(navigationController,name)
                            }

                            composable(Routes.Screen5.route, arguments = listOf(
                                navArgument("age"){defaultValue = 0}
                            )){ backStackEntry ->
                                val age :Int =  backStackEntry.arguments?.getInt("age")?:0
                                Screen5(navigationController,age)
                            }


                        }
                    }

                }
            }
        }
    }
}
    @Composable
    fun mySlider() {

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myDropDownMenu() {
        var selectedText by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta")
        var textFieldWidthSize by remember { mutableStateOf(Size.Zero) }

        Column(Modifier.padding(20.dp)) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldWidthSize = coordinates.size.toSize()
                    })
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier
                .width(with(LocalDensity.current) {
                    textFieldWidthSize.width.toDp()
                })
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = {
                        Text(text = dessert)
                    },
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyDropDownMenu1() {
        var selectedText by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        var textFieldWidthSize by remember { mutableStateOf(Size.Zero) }
        val desserts = listOf("Helado", "Chocolate", "Pie", "Galleta", "Torta")

        Column {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldWidthSize = coordinates.size.toSize()
                    }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                modifier = Modifier
                    .width(with(LocalDensity.current) {
                        textFieldWidthSize.width.toDp()
                    })
            ) {
                desserts.forEach { dessert ->
                    DropdownMenuItem(
                        text = {
                            Text(text = dessert)
                        },
                        onClick = {
                            expanded = false
                            selectedText = dessert
                        }
                    )
                }
            }
        }
    }

    //            desserts.map {
//                DropdownMenuItem(text = { it },
//                    onClick = {
//                        expanded = false
//                        selectedText = it
//                    }){
//                    Text(text = "Ejemplo 1 card")
//                }

    @Composable
    fun myDivider() {
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), color = Color.Red
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myBadgedBox() {
        BadgedBox(badge = { Badge { Text("8") } }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )
        }
    }

    @Composable
    fun myCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(contentColor = Color.Red, containerColor = Color.Blue),
            border = BorderStroke(5.dp, Color.Cyan)
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(text = "Ejemplo 1 card")
                Text(text = "Ejemplo 1 card")
                Text(text = "Ejemplo 1 card")
            }
        }
    }

    @Composable
    fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = name == "Aris",
                    onClick = { onItemSelected("Aris") },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Blue,
                        disabledUnselectedColor = Color.Green,
                        disabledSelectedColor = Color.Yellow
                    )
                )
                Text(text = "Aris")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = name == "Hector",
                    onClick = { onItemSelected("Hector") },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Blue,
                        disabledUnselectedColor = Color.Green,
                        disabledSelectedColor = Color.Yellow
                    )
                )
                Text(text = "Hector")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = name == "Jose",
                    onClick = { onItemSelected("Jose") },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Blue,
                        disabledUnselectedColor = Color.Green,
                        disabledSelectedColor = Color.Yellow
                    )
                )
                Text(text = "Jose")
            }
        }
    }


    @Composable
    fun myRadioButton() {

        Row() {
            RadioButton(
                selected = true,
                onClick = { },
                enabled = false,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Blue,
                    disabledUnselectedColor = Color.Green,
                    disabledSelectedColor = Color.Yellow
                )
            )
            Text(text = "Mi RadioB")
        }

    }

    //    @Preview
    @Composable
    fun myTriStatus() {
        var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
        TriStateCheckbox(state = status, onClick = {
            status = when (status) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })

    }

    @Composable
    fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkInfo.selected,
                onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Magenta, uncheckedColor = Color.Cyan
                )
            )
            Spacer(Modifier.width(8.dp))
            Text(text = checkInfo.title)
        }
    }

    @Composable
    fun getOptions(titles: List<String>): List<CheckInfo> {
        return titles.map {
            var status by rememberSaveable { mutableStateOf(false) }

            CheckInfo(
                title = it,
                selected = status,
                onCheckedChange = { myNewStatus -> status = myNewStatus }
            )
        }

    }

    @Composable
    fun MyCheckBoxWithText() {
        var state by rememberSaveable { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = !state },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red, uncheckedColor = Color.Blue
                )
            )
            Spacer(Modifier.width(8.dp))
            Text(text = "Ejemplo 1")
        }


    }


    @Composable
    fun DefaultPreview() {
        JetpackComposeCatalogoTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize()
//            color = MaterialTheme.colors.Modifier.background()) {
//
//        }
//        MyBox()
//        MyColumn()
//        MyComplexLayout()
//        MyText()
//        MyTextField()
//        MyTextFieldOutlined()
//        MyButtonExample()
//        MyImage()
//        MyImageAdvance()
//        MyIcons()
//        MyProgress()
//        MyProgressAdvance()
//        MySwitch()
//        Column() {
//            MyCheckBoxWithText()
//            MyCheckBoxWithText()
//        }
        }
    }

    @Composable
    fun GreetingPreview() {
        JetpackComposeCatalogoTheme {
//        MyBox()
//        MyColumn()
            MyComplexLayout()
        }
    }


    @Composable
    fun MySpacer(size: Int) {
        Spacer(modifier = Modifier.height(size.dp))
    }

    @Composable
    fun MyComplexLayout() {
        Column(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Texto interno 1")
            }
            MySpacer(30)
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Tecto interno 2")
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Tecto interno 3")
                }
            }
            MySpacer(80)
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Magenta),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = "Tecto interno 4")
            }

        }
    }

    @Composable
    fun MyRow() {
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Magenta)
            )
        }
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Yellow)
            )
        }

        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Blue)
            )
        }
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
            Text(
                "Ejemplo 2", modifier = Modifier.background(Color.Green)
            )
        }
    }

    @Composable
    fun MyColumn() {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                "Ejemplo 1", modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
            )
//        Text("Ejemplo 2", modifier = Modifier.background(Color.Cyan))
//        Text("Ejemplo 3", modifier = Modifier.background(Color.Blue))
//        Text("Ejemplo 4", modifier = Modifier.background(Color.Green))
//        Text("Ejemplo 5", modifier = Modifier.background(Color.Magenta))
//        Text("Ejemplo 6", modifier = Modifier.background(Color.Yellow))
        }
    }

    @Composable
    fun MyBox(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Cyan)
                    .width(200.dp)
                    .height(200.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ), contentAlignment = Alignment.BottomCenter
            ) {
                Text("Ejemplo mas largo de prueba")
            }
        }
    }

    @Composable
    fun MyStateExample() {
        var counter by rememberSaveable { mutableStateOf(0) }
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { counter++ }) {
                Text(text = "Pulsar")
            }
            Text(text = "He sido pulsado ${counter} veces")
        }
    }


    @Composable
    fun MyProgress() {
        var showLoading by rememberSaveable { mutableStateOf(false) }

        Column(
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (showLoading) {
                CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
                LinearProgressIndicator(
                    modifier = Modifier.padding(top = 32.dp), color = Color.Red, Color.Cyan
                )
            }
            Button(
                onClick = { showLoading = !showLoading },
                colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Blue),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "showLoading")
            }

        }
    }

    @Composable
    fun MyCheckBox() {
        var state by rememberSaveable { mutableStateOf(false) }
        Checkbox(
            checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red, uncheckedColor = Color.Yellow
            )
        )
    }

    @Composable
    fun MySwitch() {
        var state by rememberSaveable { mutableStateOf(false) }
        Switch(
            checked = state, onCheckedChange = { state = !state }, colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Magenta,
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Cyan
            )
        )
    }


    @Composable
    fun MyProgressAdvance() {
        var amountProgress by rememberSaveable { mutableStateOf(0f) }

        Column(
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

//        if(showLoading){ }
            CircularProgressIndicator(
                color = Color.Red, strokeWidth = 10.dp, progress = amountProgress
            )
            LinearProgressIndicator(
                progress = amountProgress,
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                Color.Cyan,
            )

            Button(
                onClick = {
                    if (amountProgress < 1) {
                        amountProgress += 0.1f
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Blue),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "Incrementar")
            }
            Button(
                onClick = {
                    if (amountProgress > 0.1) {
                        amountProgress -= 0.1f
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Blue),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "Reducir")
            }

        }
    }

    @Composable
    fun MyIcons() {
        Icon(
            imageVector = Icons.Rounded.Stars, contentDescription = "icono", tint = Color.Red
        )
    }

    @Composable
    fun MyImageAdvance() {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Ejemplo Image",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape),
            alpha = 0.5f
        )
    }

    @Composable
    fun MyImage() {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Ejemplo Image",
            alpha = 0.5f
        )
    }


    @Composable
    fun MyButtonExample() {

        var enabled by rememberSaveable { mutableStateOf(true) }
        Column(Modifier.fillMaxSize()) {
            Button(onClick = {

            }) {
                Text(text = "Hola")
                Text(text = "Hola")
            }
            TextButton(onClick = {}) {
                Text(text = "TextButton")

            }
            Button(
                onClick = { enabled = false },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Blue),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "Hola")

            }
            OutlinedButton(
                onClick = { enabled = false },
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Magenta, contentColor = Color.Blue, disabledContainerColor = Color.Cyan
                ),
                enabled = enabled,
            ) {
                Text(text = "Outlined")
            }
        }

    }

    @Composable
    fun MyText() {
        var counter by rememberSaveable { mutableStateOf(0) }
        Column(
            Modifier.fillMaxSize()
        ) {
            Text(text = "Esto es un ejemplo")
            Text(text = "Esto es un ejemplo", color = Color.Blue)
            Text(
                text = "Esto es un ejemplo",
                color = Color.Magenta,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = "Esto es un ejemplo", color = Color.Cyan, fontWeight = FontWeight.Light)
            Text(
                text = "Esto es un ejemplo",
                color = Color.Cyan,
                style = TextStyle(fontFamily = FontFamily.Cursive)
            )
            Text(
                text = "Esto es un ejemplo",
                color = Color.Cyan,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                text = "Esto es un ejemplo",
                color = Color.Cyan,
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
            Text(
                text = "Esto es un ejemplo",
                color = Color.Cyan,
                style = TextStyle(textDecoration = TextDecoration.None)
            )
            Text(
                text = "Esto es un ejemplo", color = Color.Cyan, style = TextStyle(
                    textDecoration = TextDecoration.combine(
                        listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                    )
                )
            )
            Text(text = "Esto es un ejemplo", fontSize = 30.sp)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField() {
        var myText by remember {
            mutableStateOf("")
        }
        TextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = { Text(text = "Introduce") })
    }

    //@Preview(showBackground = true)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextFieldOutlined(name: String, onValueChenged: (String) -> Unit) {
        var myText by remember {
            mutableStateOf("")
        }
        Column(
            Modifier.fillMaxSize()
        ) {
            Text(text = "Esto es un ejemplo 3")

            OutlinedTextField(value = name, onValueChange = { onValueChenged(it) })

            OutlinedTextField(
                value = myText,
                onValueChange = {
                    myText = if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
                },
                label = { Text(text = "Introduce algo outlined 1") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue
                )
            )
            OutlinedTextField(
                value = myText,
                onValueChange = {
                    myText = if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
                },
                label = { Text(text = "Introduce algo outlined") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Red
                )
            )
        }
    }
