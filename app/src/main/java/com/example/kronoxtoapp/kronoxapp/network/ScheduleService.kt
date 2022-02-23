package com.example.kronoxtoapp.kronoxapp.network

import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTO
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScheduleService{
    @GET("schedules/search/")
    suspend fun search(
        @Query("search") id: String
    ): ScheduleInfoDTO

    @GET("schedules/{id}")
    suspend fun get(
        @Path("id") id: String,
        @Query("year") year: String,
        @Query("month") month: String,
        @Query("day") day: String
    ): ScheduleDTO
}