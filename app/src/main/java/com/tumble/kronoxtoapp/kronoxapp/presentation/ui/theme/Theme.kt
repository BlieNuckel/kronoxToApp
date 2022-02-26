package com.tumble.kronoxtoapp.kronoxapp.presentation.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
){
    MaterialTheme(
        typography = SegueTypography,
        colors = LightColors
    ){
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
        systemUiController.statusBarDarkContentEnabled = true
        content()
    }
}