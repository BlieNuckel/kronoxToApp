package com.example.kronoxtoapp.kronoxapp.network.model

import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.domain.util.DomainMapper


/* The purpose of this class and its functions is to convert entities (like the JSON object
*   the Rest API returns) into actual Android Class objects we can use in the code. */
class ScheduleInfoDTOMapper : DomainMapper<ScheduleInfoDTO, ScheduleInfo> {
    override fun mapToDomainModel(model: ScheduleInfoDTO): ScheduleInfo{
        return ScheduleInfo(
            scheduleInfo = model.scheduleInfo
        )
    }
    override fun mapFromDomainModel(domainModel: ScheduleInfo): ScheduleInfoDTO {
        return ScheduleInfoDTO(
            scheduleInfo = domainModel.scheduleInfo
        )
    }

}