package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleListViewModel
@Inject
constructor(
    private val randomString: String,
    private val repo: ScheduleRepo
): ViewModel()
{
    private val _schedules: MutableLiveData<List<Schedule>> = MutableLiveData()

    /* READ ONLY DATA FOR UI */
    val schedules: LiveData<List<Schedule>> get() = _schedules

    
}