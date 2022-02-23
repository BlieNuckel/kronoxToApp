package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**** This is the day divider we see in the ScheduleListFragment that separates each new day ****/
@Parcelize
data class DayDivider (
    var dayName: String? = null,
    var date: String? = null
): Parcelable