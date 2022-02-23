package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram


/**** The compose view for the cards of programs and their program codes, in S ****/
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProgramCard(
    schedule: AvailableProgram,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){

        Surface(
            contentColor = Color(android.graphics.Color.parseColor("#" + "4D4D4D")),
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxWidth()
                .height(100.dp)
                .clickable(onClick = onClick)
                .background(Color.White)
        ) {
            Column(
            ) {
                schedule.scheduleName?.let { title ->
                    val splitTitle = title.split(", ")

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                    ){
                        Column() {
                            Text(
                                text = splitTitle[0],
                                modifier = Modifier
                                    .wrapContentWidth(Alignment.Start)
                                    .padding(top = 3.dp),
                                style = MaterialTheme.typography.h3,

                            )

                            Text(
                                text = splitTitle[1],
                                maxLines = 2,
                                modifier = Modifier
                                    .wrapContentWidth(Alignment.Start)
                                    .padding(top = 5.dp),
                                style = MaterialTheme.typography.h3,
                                fontWeight = FontWeight.W200
                            )
                        }

                    }

                }
            }
        }
    }
}