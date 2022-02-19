package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleListViewModel
@Inject
constructor(
    private val repo: ScheduleRepo
): ViewModel()
{
    val schedules: MutableState<List<Schedule>> = mutableStateOf(listOf())

    init{
        viewModelScope.launch {
            val result = repo.get(
                year = "2022",
                month = "march"
            )
            schedules.value = listOf(result)
        }
    }


}