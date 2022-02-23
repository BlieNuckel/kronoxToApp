package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/* This is the data model that Retrofit uses to fetch data from
*  REST API.
*  It models what a schedule looks like coming from the network */

@Parcelize
data class ScheduleDTO(

    @SerializedName("2022")
    val year: Map<String, Map<String, List<Map<String, String>>>>? = null

) : Parcelable

