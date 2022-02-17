package com.example.kronoxtoapp.network

import com.example.kronoxtoapp.network.model.ScheduleNetworkItem
import com.example.kronoxtoapp.network.responses.ScheduleSearchResponse
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

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): ScheduleNetworkItem
}