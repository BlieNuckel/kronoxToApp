package com.example.kronoxtoapp.kronoxapp.datastorage

interface DataStoreRepo {
    suspend fun putSchedule(key: String, value: String)
    suspend fun getString(key: String): String?
}