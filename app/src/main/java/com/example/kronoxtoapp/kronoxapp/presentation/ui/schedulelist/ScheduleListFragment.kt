package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleCard
import com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule.ScheduleDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleListFragment : Fragment(){

    /* If we want to share a viewmodel between multiple fragments we need to
    * use 'activityViewModels()' instead of 'viewModels()' */
    private val viewModel: ScheduleListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply{
            setContent{

                val schedules = viewModel.schedules.value

                val scheduleDetails = listOf(ScheduleDetails(
                    start = schedules.year?.get("march")?.get("31")?.get(0)?.get("start").toString(),
                    end = schedules.year?.get("march")?.get("31")?.get(0)?.get("end").toString(),
                    course = schedules.year?.get("march")?.get("31")?.get(0)?.get("course").toString(),
                    lecturer = schedules.year?.get("march")?.get("31")?.get(0)?.get("lecturer").toString(),
                    location = schedules.year?.get("march")?.get("31")?.get(0)?.get("location").toString(),
                    title = schedules.year?.get("march")?.get("31")?.get(0)?.get("title").toString()
                ))

                LazyColumn{
                    itemsIndexed(
                        items = scheduleDetails
                    ){ index, schedule ->
                        ScheduleCard(schedule = schedule, onClick = {})
                    }
                }
            }
        }
    }
}