package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule

interface ScheduleRepo {

    suspend fun search(query: String): Schedule

    suspend fun get(year: String, month: String, day: String): Schedule
}