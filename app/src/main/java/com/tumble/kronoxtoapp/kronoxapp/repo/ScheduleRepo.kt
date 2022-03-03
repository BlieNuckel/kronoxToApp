package com.tumble.kronoxtoapp.kronoxapp.repo

import com.tumble.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.tumble.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo

/**** Model for the functions needed to perform a search query to our API ****/
interface ScheduleRepo {

    suspend fun search(query: String): ScheduleInfo

    suspend fun get(id: String, year: String, month: String, day: String): Schedule

}