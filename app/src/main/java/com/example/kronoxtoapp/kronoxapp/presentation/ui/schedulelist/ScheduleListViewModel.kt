package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import kotlin.collections.HashMap

@HiltViewModel
class ScheduleListViewModel
@Inject
constructor(
    private val repo: ScheduleRepo,
    @Named("api_id") val api_id: String,
    @Named("month") val month: String,
    @Named("day") val day: String
): ViewModel()
{
    val schedules: MutableState<List<Any>> = mutableStateOf(listOf())

    var loading = mutableStateOf(false)

    init{
        try{
            newGet()
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    /* This function converts a Schedule object into a list of Schedule Details.
    *  It bypasses all null values in a month (avoiding the days that aren't available in
    *  the JSON object) by using the .let{} function. We also fetch the current month by using
    *  the index from Calendar.MONTH and getting its value from a list of month keys. */
    private fun newGet(){
        viewModelScope.launch{
            loading.value = true

            val result = repo.get(
                year = api_id,
                day = day,
                month = month
            )

            val scheduleList: MutableList<Any> = mutableListOf()
            val months: List<String> = listOf("january", "february", "march", "april", "may",
                "june", "july", "august", "september", "october", "november", "december")


            for(k in 0..6.minus(Calendar.MONTH)){
                result.year?.get(months[Calendar.MONTH-1+k]).let {
                    (0..31).forEach { i: Int ->
                        if(it?.contains(i.toString()) == true){
                            scheduleList.add(
                                DayDivider(
                                    dayName = it[i.toString()]?.get(0)?.get("dayName"),
                                    date = it[i.toString()]?.get(0)?.get("date")
                                )
                            )
                            val temp = HashMap(it)
                            temp[i.toString()] = it[i.toString()]?.drop(1)
                            for(detail in temp[i.toString()]!!)
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
            }
            schedules.value = scheduleList
            loading.value = false
        }
    }
}