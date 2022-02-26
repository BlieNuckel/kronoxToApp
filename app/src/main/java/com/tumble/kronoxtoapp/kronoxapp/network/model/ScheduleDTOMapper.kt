package com.tumble.kronoxtoapp.kronoxapp.network.model

import com.tumble.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.tumble.kronoxtoapp.kronoxapp.domain.util.DomainMapper


/**** The purpose of this class and its functions is to convert entities (like the JSON object
*   the Rest API returns) into a Schedule item we can use in the code. ****/
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
}