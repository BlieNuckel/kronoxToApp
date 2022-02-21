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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleDetailsCard(
    schedule: ScheduleDetails,
    onClick: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        contentColor = Color(android.graphics.Color.parseColor("#" + "4D4D4D")),
        modifier = Modifier
            .padding(
                bottom = 3.dp,
                top = 3.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
        backgroundColor = Color.White
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
                        style = MaterialTheme.typography.h4,
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
                        style = MaterialTheme.typography.h5
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
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold
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
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 13.dp, start = 8.dp, end = 8.dp)
                ){
                    Text(
                        text = "Room: " + schedule.location,
                        modifier = Modifier
                            .fillMaxWidth(0.45f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 13.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = "Lecturer: " + schedule.lecturer,
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