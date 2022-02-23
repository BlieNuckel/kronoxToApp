package com.example.kronoxtoapp.kronoxapp.network.model

import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.domain.util.DomainMapper


/* The purpose of this class and its functions is to convert entities (like the JSON object
*   the Rest API returns) into actual Android Class objects we can use in the code. */
class ScheduleDTOMapper : DomainMapper<ScheduleDTO, Schedule> {
    override fun mapToDomainModel(model: ScheduleDTO): Schedule {
        return Schedule(
            schedule = model.schedule
        )
    }

    override fun mapFromDomainModel(domainModel: Schedule): ScheduleDTO {
        return ScheduleDTO(
            schedule = domainModel.schedule
        )
    }

    fun fromDomainList(initial: List<ScheduleDTO>): List<Schedule>{
        return initial.map { mapToDomainModel(it) }
    }

}