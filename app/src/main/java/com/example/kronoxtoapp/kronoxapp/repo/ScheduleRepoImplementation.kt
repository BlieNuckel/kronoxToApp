package com.example.kronoxtoapp.kronoxapp.repo

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper

class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper
): ScheduleRepo {
    override suspend fun search(token: String, page: Int, query: String): List<Schedule> {
        TODO("Not yet implemented")
    }

    /* This is the get request function, it can be changed to receive specific primary
    *  keys, can be modified in the future  */
    override suspend fun get(id: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(id))
    }
}