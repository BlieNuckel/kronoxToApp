package com.example.kronoxtoapp.kronoxapp.repo

import androidx.compose.runtime.MutableState
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper

class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper
): ScheduleRepo {
    override suspend fun search(id: String, year: String, month: String, day: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.search(id, year, month, day).schedules)
    }

    override suspend fun get(id: String, year: String, month: String, day: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(id, year, month, day))
    }
}