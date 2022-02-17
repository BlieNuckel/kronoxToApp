package com.example.kronoxtoapp.activities.domain.util

/* DomainModel is our Schedule and Entity is ScheduleNetworkItems */
interface EntityMapper <Entity, DomainModel> {

    /* This function receives an entity and converts it to a Schedule */
    fun mapFromSchedule(entity: Entity): DomainModel

    fun mapToSchedule(domainModel: DomainModel): Entity
}