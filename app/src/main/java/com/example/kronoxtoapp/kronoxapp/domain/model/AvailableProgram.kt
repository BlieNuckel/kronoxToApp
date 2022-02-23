package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**** This is the individual values that each available schedule found in a search ****/
@Parcelize
data class AvailableProgram(
    val scheduleId: String? = null,
    val scheduleName: String? = null
):Parcelable
