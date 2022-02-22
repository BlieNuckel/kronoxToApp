package com.example.kronoxtoapp.kronoxapp.repo

import androidx.compose.runtime.MutableState
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule

interface ScheduleRepo {

    suspend fun search(id: String, year: String, month: String, day: String): Schedule

    suspend fun get(id: String, year: String, month: String, day: String): Schedule
}