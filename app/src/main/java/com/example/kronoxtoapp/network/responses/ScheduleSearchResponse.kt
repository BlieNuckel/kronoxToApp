package com.example.kronoxtoapp.network.responses

import com.example.kronoxtoapp.network.model.ScheduleDTO
import com.google.gson.annotations.SerializedName

data class ScheduleSearchResponse (
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var schedules: List<ScheduleDTO>
)