package com.tumble.kronoxtoapp.kronoxapp.repo

interface DataStoreRepo {
    suspend fun putSchedule(key: String, value: String)
    suspend fun getString(key: String): String?
}