package com.example.kronoxtoapp.kronoxapp.network

import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTO
import com.example.kronoxtoapp.kronoxapp.network.responses.ScheduleSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ScheduleService{
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): ScheduleSearchResponse

    @GET("p.TBSE2+2021+35+100+NML+en")
    suspend fun get(
        @Query("id") id: String
    ): ScheduleDTO
}