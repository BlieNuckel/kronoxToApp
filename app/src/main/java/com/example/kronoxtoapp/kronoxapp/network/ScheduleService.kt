package com.example.kronoxtoapp.kronoxapp.network

import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTO
import com.example.kronoxtoapp.kronoxapp.network.responses.ScheduleSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleService{
    @GET("p.TBSE2+2021+35+100+NML+en")
    suspend fun search(
        @Query("id") query: String
    ): ScheduleSearchResponse

    @GET("p.TBSE2+2021+35+100+NML+en")
    suspend fun get(
        @Query("year") year: String,
        @Query("month") month: String,
    ): ScheduleDTO
}