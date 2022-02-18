package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule

interface ScheduleRepo {

    suspend fun search(token: String, page: Int, query: String): List<Schedule>

    suspend fun get(id: String): Schedule
}