package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleInfo(
    val scheduleInfo: List<Map<String, String>>? = null
): Parcelable
