package com.example.kronoxtoapp.network.model

import com.example.kronoxtoapp.activities.domain.model.Schedule
import com.example.kronoxtoapp.activities.domain.util.EntityMapper

class ScheduleNetworkMapper : EntityMapper<ScheduleNetworker, Schedule> {

    override fun mapFromSchedule(entity: ScheduleNetworker): Schedule {
        return Schedule(
            year = entity.year
        )
    }

    override fun mapToSchedule(domainModel: Schedule): ScheduleNetworker {
        TODO("Not yet implemented")
    }


    /* Returns inididual entities from list of Schedules */
    fun fromScheduleList(initial: List<ScheduleNetworker>): List<Schedule>{
        return initial.map{ mapFromSchedule(it)}
    }
}