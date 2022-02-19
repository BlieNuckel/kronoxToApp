package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.Year
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ScheduleListViewModel
@Inject
constructor(
    private val repo: ScheduleRepo,
    @Named("api_id") val api_id: String
): ViewModel()
{
    val schedules: MutableState<Schedule> = mutableStateOf(Schedule())

    init{
        viewModelScope.launch{
            val result = repo.get(
                year = api_id
            )
            schedules.value = result
        }
    }
}