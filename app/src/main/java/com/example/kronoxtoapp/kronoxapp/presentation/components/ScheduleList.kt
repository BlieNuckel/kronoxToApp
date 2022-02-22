package com.example.kronoxtoapp.kronoxapp.presentation.components

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.preview.SampleDataProvider
import com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist.ScheduleListFragment

@Composable
fun ScheduleList(
    loading: Boolean,
    schedules: List<Any>,
    navController: NavController,
){
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    /* Used to remember state of scaffold during execution of program */

    /*Scaffold(
        scaffoldState = state
    ){

    }*/

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            itemsIndexed(
                items = schedules
            ){ _, schedule ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
                                    navController.navigate(R.id.scheduleFragment, bundle)
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