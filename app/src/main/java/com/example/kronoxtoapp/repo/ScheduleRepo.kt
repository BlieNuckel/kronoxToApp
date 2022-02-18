package com.example.kronoxtoapp.repo

import com.example.kronoxtoapp.activities.domain.model.Schedule

interface ScheduleRepo {

    suspend fun search(token: String, page: Int, query: String): List<Schedule>

    suspend fun get(id: String): Schedule
}