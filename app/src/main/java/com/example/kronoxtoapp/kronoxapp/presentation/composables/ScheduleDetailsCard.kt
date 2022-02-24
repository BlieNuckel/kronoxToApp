package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleDetailsCard(
    schedule: ScheduleDetails,
    onClick: () -> Unit
){

    val dateFormatter = DateTimeFormatter.ISO_DATE_TIME
    val startDateTime = LocalDateTime.parse(schedule.start, dateFormatter)
    val endDateTime = LocalDateTime.parse(schedule.end, dateFormatter)

    // Container for the entire page
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Date and time container
        Box(
            modifier = Modifier
                .padding(start = 20.dp, top = 50.dp)
        ) {
            // Column for Week day and time + date row on next line
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = startDateTime.dayOfWeek.toString(),
                    fontSize = 75.sp,
                    color = Color(android.graphics.Color.parseColor("#" + "3B3B3B")),
                    modifier = Modifier
                        .offset(x = (-4).dp)
                )
                // Row for containing Time and date
                Row(
                    modifier = Modifier
                        .padding(0.dp)
                        .offset(y = (-30).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Column for the stacked time stamps
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = String.format("%02d:%02d", startDateTime.hour, startDateTime.minute),
                            fontSize = 29.sp,
                            fontWeight = FontWeight.W300,
                            textAlign = TextAlign.Center,
                            color = Color(android.graphics.Color.parseColor("#" + "707070")),
                            modifier = Modifier
                                .padding(0.dp)
                                .offset(y = 5.dp)
                        )

                        Text(
                            text = String.format("%02d:%02d", endDateTime.hour, endDateTime.minute),
                            fontSize = 29.sp,
                            fontWeight = FontWeight.W300,
                            textAlign = TextAlign.Center,
                            color = Color(android.graphics.Color.parseColor("#" + "707070")),
                            modifier = Modifier
                                .padding(0.dp)
                                .offset(y = (-2).dp)
                        )
                    }

                    Text(
                        text = startDateTime.month.getDisplayName(TextStyle.SHORT, Locale.US).uppercase() + " " + startDateTime.dayOfMonth,
                        fontSize = 75.sp,
                        color = Color(android.graphics.Color.parseColor("#" + "3B3B3B")),
                    )
                }
            }
        }

        // Splitter row for the 2 splitter elements
        Row(
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_detail_card_splitter),
                contentDescription = null,
                tint = Color(android.graphics.Color.parseColor(schedule.color)).copy(alpha = 0.35f),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_detail_card_splitter),
                contentDescription = null,
                tint = Color(android.graphics.Color.parseColor(schedule.color)).copy(alpha = 0.35f),
                modifier = Modifier
                    .fillMaxWidth()
                    .rotate(180f)
            )
        }

        // Container for course name + description
        Surface(
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
                .fillMaxWidth(),
            elevation = 2.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Text(
                    text = if (schedule.course.toString().length > 120) {
                        schedule.course.toString().substring(0, 120) + "..."
                    } else {
                        schedule.course.toString()
                    },
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                Text(
                    text = if (schedule.title.toString().length > 200) {
                        schedule.title.toString().substring(0, 200) + "..."
                    } else {
                        schedule.title.toString()
                    },
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W300
                )
            }
        }
    }
}