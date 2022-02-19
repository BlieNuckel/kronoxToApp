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

    /*override suspend fun search(query: String): List<Schedule> {
        return mapper.toScheduleList(scheduleService.search(query = query).schedules)
    }*/


    /* This is the get request function, it can be changed to receive specific primary
    *  keys, can be modified in the future  */
    override suspend fun get(id: String): Schedule {
        return mapper.mapToDomainModel(scheduleService.get(id))
    }
}