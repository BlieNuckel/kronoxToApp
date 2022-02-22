package com.example.kronoxtoapp.kronoxapp.network

import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTO
import com.example.kronoxtoapp.kronoxapp.network.responses.ScheduleSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ScheduleService{
    @GET("schedules/")
    suspend fun search(
        @Query("id") id: String,
        @Query("year") year: String,
        @Query("month") month: String,
        @Query("day") day: String
    ): ScheduleSearchResponse

    @GET("schedules/{id}")
    suspend fun get(
        @Path("id") id: String,
        @Query("year") year: String,
        @Query("month") month: String,
        @Query("day") day: String
    ): ScheduleDTO
}