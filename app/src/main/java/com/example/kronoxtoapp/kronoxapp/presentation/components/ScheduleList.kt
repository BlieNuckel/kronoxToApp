package com.example.kronoxtoapp.kronoxapp.presentation.components

import android.os.Build
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails

@Composable
fun ScheduleList(
    loading: Boolean,
    schedules: List<ScheduleDetails>,
    navController: NavController,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            itemsIndexed(
                items = schedules
            ){ index, schedule ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ScheduleCard(
                        schedule = schedule,
                        onClick = {
                            if(schedule.course != null){
                                val bundle = Bundle()
                                bundle.putParcelable("schedule", schedule)
                                navController.navigate(R.id.detail_schedule, bundle)
                            }
                        })
                }
            }
        }
        CircularProgressBar(
            isDisplayed = loading
        )
    }
}