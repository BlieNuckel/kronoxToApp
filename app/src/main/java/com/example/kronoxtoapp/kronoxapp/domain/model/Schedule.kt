package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.kronoxapp.network.model.MonthsDTO
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(

    val year: MonthsDTO? = null

) : Parcelable