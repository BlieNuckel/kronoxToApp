package com.tumble.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**** This is the model for the remapping of incoming available schedules for a search ****/
@Parcelize
data class ScheduleInfo(
    val scheduleInfo: List<Map<String, String>>? = null
): Parcelable
