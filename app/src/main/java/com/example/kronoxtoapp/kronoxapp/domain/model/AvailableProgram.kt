package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvailableProgram(
    val scheduleId: String? = null,
    val scheduleName: String? = null
):Parcelable
