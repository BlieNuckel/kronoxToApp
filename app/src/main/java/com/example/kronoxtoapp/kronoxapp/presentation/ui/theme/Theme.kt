package com.example.kronoxtoapp.kronoxapp.presentation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.presentation.components.CustomDropDown
import com.example.kronoxtoapp.kronoxapp.presentation.components.TopBar

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
){
    MaterialTheme(
        typography = SegueTypography,
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Top App Bar")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = Color.White,
                    elevation = 10.dp
                )
            }, content = {
                content()
            })
    }
}