package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule.ScheduleDetails
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(

    val year: Map<String, Map<String, List<Map<String, String>>>>? = null

) : Parcelable