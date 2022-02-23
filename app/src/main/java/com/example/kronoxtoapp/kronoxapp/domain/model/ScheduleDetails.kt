package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**** This is the model used for gathering details about a schedule in one place ****/
@Parcelize
data class ScheduleDetails(
    var start: String? = null,
    var end: String? = null,
    var course: String? = null,
    var lecturer: String? = null,
    var location: String? = null,
    var title: String? = null,
    var color: String? = null
) : Parcelable