package com.example.kronoxtoapp.kronoxapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DayDividerUI(
    dayName: String?,
    date: String?
){
    Box(
        modifier = Modifier
            .padding(start = 20.dp)
    ){
        if (dayName != null) {
            Text(
                text = "$dayName - $date",
            )
        }
        Divider(
            color = Color(android.graphics.Color.parseColor("#" + "6A6A6A")),
            modifier = Modifier.fillMaxWidth()
        )
    }
}