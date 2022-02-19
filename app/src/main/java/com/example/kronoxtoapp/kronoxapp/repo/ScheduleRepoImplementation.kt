package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.Year
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper

class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper
): ScheduleRepo {
    override suspend fun search(query: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.search(query).schedules)
    }

    override suspend fun get(year: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(year = year/*, month = month*/))
    }
}