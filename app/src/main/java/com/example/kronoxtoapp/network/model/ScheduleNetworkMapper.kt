package com.example.kronoxtoapp.network.model

import com.example.kronoxtoapp.activities.domain.model.Schedule
import com.example.kronoxtoapp.activities.domain.util.EntityMapper

class ScheduleNetworkMapper : EntityMapper<ScheduleNetworkItem, Schedule> {

    override fun mapFromSchedule(entity: ScheduleNetworkItem): Schedule {
        return Schedule(
            year = entity.year
        )
    }

    override fun mapToSchedule(domainModel: Schedule): ScheduleNetworkItem {
        TODO("Not yet implemented")
    }


    /* Returns inididual entities from list of Schedules */
    fun fromScheduleList(initial: List<ScheduleNetworkItem>): List<Schedule>{
        return initial.map{ mapFromSchedule(it)}
    }
}