package com.example.kronoxtoapp.kronoxapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DayDividerUI(
    dayName: String?,
    date: String?
){
    Box(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 28.dp)
    ){
        Row(
        ){
            dayName?.let {
                Text(
                    text = "$dayName - $date",
                    color = Color(android.graphics.Color.parseColor("#" + "707070"))
                )
            }
            Divider(
                color = Color(android.graphics.Color.parseColor("#" + "6A6A6A")),
                modifier =
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(start = 6.dp)
                ,
            )
        }
    }
}