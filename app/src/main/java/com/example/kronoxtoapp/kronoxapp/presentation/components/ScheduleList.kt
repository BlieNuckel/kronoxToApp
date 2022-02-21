package com.example.kronoxtoapp.kronoxapp.presentation.components

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails

@Composable
fun ScheduleList(
    loading: Boolean,
    schedules: List<Any>,
    navController: NavController,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            itemsIndexed(
                items = schedules
            ){ _, schedule ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    Log.d("APPDEBUG", "$schedule")

                    if(schedule is DayDivider){
                        DayDividerUI(
                            dayName = schedule.dayName,
                            date = schedule.date
                        )
                    }else{
                        ScheduleCard(
                            schedule = schedule as ScheduleDetails,
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
        }
        CircularProgressBar(
            isDisplayed = loading
        )
    }
}