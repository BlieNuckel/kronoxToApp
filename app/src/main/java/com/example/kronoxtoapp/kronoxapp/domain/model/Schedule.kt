package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.kronoxapp.network.model.Months
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    /* Each year contains its corresponding months */
    val year: Months? = null

) : Parcelable