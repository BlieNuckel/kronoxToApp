package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayDivider (
    var dayName: String? = null,
    var date: String? = null
): Parcelable