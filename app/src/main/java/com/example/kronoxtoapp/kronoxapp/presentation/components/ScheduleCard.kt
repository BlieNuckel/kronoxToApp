package com.example.kronoxtoapp.kronoxapp.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleCard(
    schedule: ScheduleDetails,
    onClick: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        contentColor = Color.White,
        modifier = Modifier
            .padding(
                bottom = 3.dp,
                top = 3.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
        backgroundColor = Color(android.graphics.Color.parseColor("#" + "9a6eba"))
    ) {
        Column {
            schedule.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 13.dp, bottom = 13.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = title + "\n" + schedule.location.toString(),
                        modifier = Modifier
                            .fillMaxWidth(0.45f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = schedule.course.toString() +
                                "\n"
                                + LocalDateTime.parse(
                                    schedule.start?.substring(
                                        0, schedule.start?.length?.minus(6)!!)).format(DateTimeFormatter.ofLocalizedDateTime(
                            FormatStyle.SHORT))
                                + "\n" + LocalDateTime.parse(
                            schedule.end?.substring(
                                0, schedule.start?.length?.minus(6)!!)).format(DateTimeFormatter.ofLocalizedDateTime(
                            FormatStyle.SHORT))
                        ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End),
                        style = MaterialTheme.typography.caption
                        )
                }
            }
        }
    }

}