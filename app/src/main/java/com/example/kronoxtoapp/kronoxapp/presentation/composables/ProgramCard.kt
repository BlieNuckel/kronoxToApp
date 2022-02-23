package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProgramCard(
    schedule: AvailableProgram,
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
                schedule.scheduleName?.let { title ->
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

                }
            }
        }
    }
}