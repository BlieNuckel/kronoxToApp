package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleCard
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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

                val scheduleList: List<ScheduleDetails> = parseNestedMaps(schedules)

                LazyColumn{
                    itemsIndexed(
                        items = scheduleList
                    ){ _, schedule ->
                        ScheduleCard(schedule = schedule, onClick = {})
                    }
                }
            }
        }
    }

    /* This function converts a Schedule object into a list of Schedule Details.
    *  It bypasses all null values in a month (avoiding the days that aren't available in
    *  the JSON object) by using the .let{} function. We also fetch the current month by using
    *  the index from Calendar.MONTH and getting its value from a list of month keys. */
    private fun parseNestedMaps(schedule: Schedule): List<ScheduleDetails>{
        val scheduleList: MutableList<ScheduleDetails> = mutableListOf()
        val months: List<String> = listOf("january", "february", "march", "april", "may",
            "june", "july", "august", "september", "october", "november", "december")

        schedule.year?.get(months[Calendar.MONTH]).let {
            for(i in 0..31){
                if(it?.contains(i.toString()) == true){
                    for(detail in it[i.toString()]!!)
                        scheduleList.add(
                            ScheduleDetails(
                                start = detail["start"],
                                end = detail["end"],
                                course = detail["course"],
                                lecturer = detail["lecturer"],
                                location = detail["location"],
                                title = detail["title"]
                            )
                        )
                }
            }
        }
        return scheduleList
    }

}