package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScheduleDetails(
    var start: String? = null,
    var end: String? = null,
    var course: String? = null,
    var lecturer: String? = null,
    var location: String? = null,
    var title: String? = null
) : Parcelable