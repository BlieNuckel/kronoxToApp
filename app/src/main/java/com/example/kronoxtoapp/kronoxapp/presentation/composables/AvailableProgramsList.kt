package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails

@Composable
fun AvailableProgramsList(
    loading: Boolean,
    availableSchedules: List<AvailableProgram>,
    navController: NavController,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            itemsIndexed(
                items = availableSchedules
            ){ _, schedule ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ProgramCard(
                        schedule = schedule,
                        onClick = {
                            val bundle = Bundle()
                            bundle.putParcelable("scheduleId", schedule)
                            navController.navigate(R.id.scheduleListFragment, bundle)
                        }
                    )
                }
            }
        }
        CircularProgressBar(
            isDisplayed = loading
        )
    }
}