package com.example.kronoxtoapp.activities.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.network.model.Months
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    /* Each year contains its corresponding name and
    *  Each month string contains a key value pair of */
    val year: List<Months>? = null
) : Parcelable