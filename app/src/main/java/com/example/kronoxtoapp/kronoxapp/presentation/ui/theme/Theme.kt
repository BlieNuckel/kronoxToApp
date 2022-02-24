package com.example.kronoxtoapp.kronoxapp.presentation.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
){
    MaterialTheme(
        typography = SegueTypography
    ){
        content()
    }
}