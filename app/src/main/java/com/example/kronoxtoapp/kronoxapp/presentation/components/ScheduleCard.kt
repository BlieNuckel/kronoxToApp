package com.example.kronoxtoapp.kronoxapp.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleCard(
    schedule: ScheduleDetails,
    onClick: () -> Unit
){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    ){

        Card(
            shape = RoundedCornerShape(
                6.dp,
            ),
            contentColor = Color(android.graphics.Color.parseColor("#" + "4D4D4D")),

            modifier = Modifier
                .padding(
                    bottom = 8.dp,
                    top = 8.dp,
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxWidth()
                .height(150.dp)
                .clickable(onClick = onClick)
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(6.dp)
                ),
            backgroundColor = Color.White,
        ) {
            Column(
            ) {
                schedule.title?.let { title ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 13.dp, bottom = 4.dp, start = 8.dp, end = 8.dp),
                    ){
                        Text(
                            text = if(title.length >= 50){
                                title.substring(0, 49-3) + "..."
                            }else{
                                 title
                                 },
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h3,
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 3.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                    ){
                        Text(
                            text = if(schedule.course?.length!! >= 60){
                                schedule.course?.substring(0, 59-3) + "..."
                            }else{
                                schedule.course!!
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h5,
                            color = Color(android.graphics.Color.parseColor("#" + "595959"))
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 3.dp, start = 8.dp, end = 8.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.Bottom,
                    ){
                        Text(
                            text = schedule.location.toString(),
                            modifier = Modifier
                                .fillMaxWidth(0.45f),
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .align(Alignment.TopEnd)
                .padding(end = 20.dp, top = 8.dp)
        ){
            Icon (
                painter = painterResource(R.drawable.ic_card_banner),
                contentDescription = null,
                tint = Color(android.graphics.Color.parseColor(schedule.color))
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 25.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(android.graphics.Color.parseColor("#" + "F2F2F2")))
                .width(50.dp)
            ){
            Text(
                text = LocalDateTime.parse(
                    schedule.start?.substring(0, schedule.start?.length?.minus(6)!!))
                    .format(DateTimeFormatter.ofPattern("HH:mm")),
                style = MaterialTheme.typography.caption,
                modifier = Modifier.align(Alignment.Center),
                color = Color(android.graphics.Color.parseColor("#" + "3b3b3b"))
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 25.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(android.graphics.Color.parseColor("#" + "F2F2F2")))
                .align(Alignment.BottomEnd)
                .width(50.dp),
        ){
            Text(
                text = LocalDateTime.parse(
                    schedule.end?.substring(0, schedule.end?.length?.minus(6)!!))
                    .format(DateTimeFormatter.ofPattern("HH:mm")),
                style = MaterialTheme.typography.caption,
                modifier = Modifier.align(Alignment.Center),
                color = Color(android.graphics.Color.parseColor("#" + "3b3b3b"))
            )
        }
    }
}