package com.tumble.kronoxtoapp.kronoxapp.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val orangeHighlight = Color(android.graphics.Color.parseColor("#" + "eb9605"))
private val orangeHighlightVariant = Color(android.graphics.Color.parseColor("#" + "ffbe29"))

val LightColors = lightColors(
    primary = orangeHighlight,
    primaryVariant = orangeHighlightVariant,
    secondary = Color(android.graphics.Color.parseColor("#" + "F2F2F2")),
    secondaryVariant = Color(android.graphics.Color.parseColor("#" + "595959")),
    background = Color.White,
    surface = Color.White,
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color(android.graphics.Color.parseColor("#" + "3b3b3b")),
    onBackground = Color(android.graphics.Color.parseColor("#" + "4D4D4D")),
    onSurface = Color(android.graphics.Color.parseColor("#" + "4D4D4D")),
    onError = Color.White
)

val DarkColors = darkColors(
    primary = orangeHighlight,
    primaryVariant = orangeHighlightVariant,
    secondary = Color(android.graphics.Color.parseColor("#" + "242424")),
    secondaryVariant = Color(android.graphics.Color.parseColor("#" + "2e2e2e")),
    background = Color(android.graphics.Color.parseColor("#" + "080808")),
    surface = Color(android.graphics.Color.parseColor("#" + "0f0f0f")),
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color(android.graphics.Color.parseColor("#" + "9e9e9e")),
    onBackground = Color(android.graphics.Color.parseColor("#" + "d4d4d4")),
    onSurface = Color(android.graphics.Color.parseColor("#" + "d4d4d4")),
    onError = Color.White
)