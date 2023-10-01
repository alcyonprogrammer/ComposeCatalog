package com.alcyonstudio.jetpackcomposecatalogo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.RangeSlider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = {sliderPosition = it})
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(value = sliderPosition,
            onValueChange = {sliderPosition = it},
            onValueChangeFinished = {completeValue = sliderPosition.toString()},
            valueRange = 0f..100f, steps = 9)
        Text(text = sliderPosition.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentRange by remember { mutableStateOf(0f..10f) }
        RangeSlider(
            value = currentRange,
            onValueChange = {currentRange = it},
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = currentRange.toString())
    }
}