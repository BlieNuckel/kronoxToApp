package com.example.kronoxtoapp.kronoxapp.domain.util

/* DomainModel is our Year and T is ScheduleNetworkItems */
interface DomainMapper <T, DomainModel> {

    /* This function receives an entity and converts it to a Year,
    * maps DTO's to Domain Models */
    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel): T
}