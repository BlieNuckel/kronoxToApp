package com.example.kronoxtoapp.kronoxapp.repo

import androidx.compose.runtime.MutableState
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo

interface ScheduleRepo {

    suspend fun search(query: String): ScheduleInfo

    suspend fun get(id: String, year: String, month: String, day: String): Schedule

}