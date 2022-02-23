package com.example.kronoxtoapp.kronoxapp.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**** The compose view found in ScheduleListView, splitting list items by their days ****/
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
                    color = Color(android.graphics.Color.parseColor("#" + "707070")),
                    style = MaterialTheme.typography.subtitle1
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