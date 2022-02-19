package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule

interface ScheduleRepo {

    suspend fun search(query: String): List<Schedule>

    suspend fun get(year: String, month: String, ): Schedule
}