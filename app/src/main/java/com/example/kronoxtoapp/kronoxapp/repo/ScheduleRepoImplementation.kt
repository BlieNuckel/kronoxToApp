package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper

class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper
): ScheduleRepo {
    override suspend fun search(query: String): List<Schedule> {
        TODO("Not yet implemented")
    }

    override suspend fun get(year: String, month: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(year = year, month = month))
    }
}