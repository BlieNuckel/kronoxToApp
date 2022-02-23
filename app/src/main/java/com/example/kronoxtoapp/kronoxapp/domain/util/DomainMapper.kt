package com.example.kronoxtoapp.kronoxapp.domain.util


/**** DomainModel is our object of years and T is ScheduleDTO ****/
interface DomainMapper <T, DomainModel> {

    /**** This function receives an entity and converts it to a schedule found in domain.model,
    * maps DTO's to Domain Models ****/
    fun mapToDomainModel(model: T): DomainModel

    /**** This function does the opposite, in case we need it in the future ****/
    fun mapFromDomainModel(domainModel: DomainModel): T
}