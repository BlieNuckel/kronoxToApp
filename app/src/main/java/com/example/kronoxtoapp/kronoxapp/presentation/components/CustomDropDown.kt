package com.example.kronoxtoapp.kronoxapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize


@Composable
fun DropDownMenu() {

    var expanded by remember { mutableStateOf(false)}
    val list = listOf("TGDU3", "SGGS2")
    var selectedItem by remember { mutableStateOf("") }

    var textFilledSize by remember { mutableStateOf(Size.Zero)}

    val icon = if(expanded) {
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }
    
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFilledSize = coordinates.size.toSize()
                },
            label = {
                Text(
                    text = "Selected schedule"
            )},
            trailingIcon = {
                Icon(icon, "", Modifier.clickable{ expanded = !expanded})
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){textFilledSize.width.dp })
        ) {

            selectedItem.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label.toString()
                    expanded = false
                }) {
                    Text(
                        text = label.toString()
                    )
                }
            }

        }
    }
}