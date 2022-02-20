package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScheduleDetails(
    val start: String? = null,
    val end: String? = null,
    val course: String? = null,
    val lecturer: String? = null,
    val location: String? = null,
    val title: String? = null
) : Parcelable