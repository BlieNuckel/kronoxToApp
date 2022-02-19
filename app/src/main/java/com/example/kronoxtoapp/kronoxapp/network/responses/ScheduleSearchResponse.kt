package com.example.kronoxtoapp.kronoxapp.network.responses

import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTO
import com.google.gson.annotations.SerializedName

data class ScheduleSearchResponse (
    @SerializedName("2022")
    var schedules: ScheduleDTO
)