package com.tumble.kronoxtoapp.kronoxapp.repo

import com.tumble.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.tumble.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.tumble.kronoxtoapp.kronoxapp.network.util.ScheduleService
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTOMapper

/**** The implementation of ScheduleRepo and its functions ****/
class ScheduleRepoImplementation(
    private val scheduleService: ScheduleService,
    private val mapper: ScheduleDTOMapper,
    private val searchMapper: ScheduleInfoDTOMapper
): ScheduleRepo {
    override suspend fun search(query: String): ScheduleInfo {
        return searchMapper.mapToDomainModel(scheduleService.search(query))
    }
    override suspend fun get(id: String, year: String, month: String, day: String): Schedule {
        return try{
            mapper.mapToDomainModel(scheduleService.get(id, year, month, day))
        } catch (e: retrofit2.HttpException) {
            Schedule(schedule = null)
        }
    }
}