package com.example.kronoxtoapp.activities.domain.util

/* DomainModel is our Schedule and T is ScheduleNetworkItems */
interface DomainMapper <T, DomainModel> {

    /* This function receives an entity and converts it to a Schedule,
    * maps DTO's to Domain Models */
    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel): T
}