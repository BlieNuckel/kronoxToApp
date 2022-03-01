package com.tumble.kronoxtoapp.kronoxapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
){
    MaterialTheme(
        typography = SegueTypography,
        colors = if (darkTheme) DarkColors else LightColors
    ){
        val systemUiController = rememberSystemUiController()
        if (darkTheme) {
            systemUiController.setSystemBarsColor(
                color = DarkColors.background
            )
            systemUiController.statusBarDarkContentEnabled = false
        } else {
            systemUiController.setSystemBarsColor(
                color = LightColors.background
            )
            systemUiController.statusBarDarkContentEnabled = true
        }

        content()
    }
}