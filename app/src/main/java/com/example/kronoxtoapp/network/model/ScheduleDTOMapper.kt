package com.example.kronoxtoapp.network.model

import com.example.kronoxtoapp.activities.domain.model.Schedule
import com.example.kronoxtoapp.activities.domain.util.DomainMapper

class ScheduleDTOMapper : DomainMapper<ScheduleDTO, Schedule> {

    override fun mapToDomainModel(model: ScheduleDTO): Schedule {
        return Schedule(
            year = model.year
        )
    }

    override fun mapFromDomainModel(domainModel: Schedule): ScheduleDTO {
        TODO("Not yet implemented")
    }


    /* Returns inididual entities from list of Schedules */
    fun fromScheduleList(initial: List<ScheduleDTO>): List<Schedule>{
        return initial.map{ mapToDomainModel(it)}
    }
}