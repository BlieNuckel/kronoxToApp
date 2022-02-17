package com.example.kronoxtoapp.network.responses

import com.example.kronoxtoapp.network.model.ScheduleNetworkItem
import com.google.gson.annotations.SerializedName

class ScheduleSearchResponse (
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var schedules: List<ScheduleNetworkItem>
)