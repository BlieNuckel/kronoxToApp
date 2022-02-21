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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
                        .padding(top = 13.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.99f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = schedule.course.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = "Starting at: " + LocalDateTime.parse(
                            schedule.start?.substring(
                                0, schedule.start?.length?.minus(6)!!))
                                    .format(DateTimeFormatter.ofPattern("dd MMMM HH:mm")),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.caption
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = "Ending at: " + LocalDateTime.parse(
                            schedule.end?.substring(
                                0, schedule.start?.length?.minus(6)!!))
                            .format(DateTimeFormatter.ofPattern("dd MMMM HH:mm")),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.caption
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 13.dp, bottom = 13.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = "Location: " + schedule.location.toString(),
                        modifier = Modifier
                            .fillMaxWidth(0.45f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }

}