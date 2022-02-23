package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleInfoDTO(
    @SerializedName("requestedSchedule")
    val scheduleInfo: List<Map<String, String>>? = null
): Parcelable