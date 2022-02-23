package com.example.kronoxtoapp.kronoxapp.repo

import androidx.compose.runtime.MutableState
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTOMapper

class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper,
    private val searchMapper: ScheduleInfoDTOMapper
): ScheduleRepo {
    override suspend fun search(query: String): ScheduleInfo {
        return searchMapper.mapToDomainModel(scheduleService.search(query))
    }

    override suspend fun get(id: String, year: String, month: String, day: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(id, year, month, day))
    }
}