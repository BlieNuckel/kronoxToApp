package com.example.kronoxtoapp.kronoxapp.network.model

import android.util.Log
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.domain.util.DomainMapper


/**** The purpose of this class and its functions is to convert entities (like the JSON object
*   the Rest API returns) into a Schedule item we can use in the code. ****/
class ScheduleDTOMapper : DomainMapper<ScheduleDTO, Schedule> {
    override fun mapToDomainModel(model: ScheduleDTO): Schedule {
        Log.d("APPDEBUG", model.schedule.toString())
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