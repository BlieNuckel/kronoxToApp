package com.example.kronoxtoapp.activities.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.network.model.Days
import com.example.kronoxtoapp.network.model.DetailsForDay
import com.example.kronoxtoapp.network.model.Months
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    /* Each year contains its corresponding months */
    val year: Months? = null

) : Parcelable