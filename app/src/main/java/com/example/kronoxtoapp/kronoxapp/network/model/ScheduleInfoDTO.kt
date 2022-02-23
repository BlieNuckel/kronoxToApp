package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**** This is what an incoming JSON object looks like for the 'matching' searches in the menu ****/
@Parcelize
data class ScheduleInfoDTO(
    @SerializedName("requestedSchedule")
    val scheduleInfo: List<Map<String, String>>? = null
): Parcelable