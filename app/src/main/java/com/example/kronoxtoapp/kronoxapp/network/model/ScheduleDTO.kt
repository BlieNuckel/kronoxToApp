package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**** This is the data model that Retrofit uses to fetch data from the REST API.
    * It models what a schedule looks like coming from the network and what key to look for ****/
@Parcelize
data class ScheduleDTO(
    @SerializedName("schedule")
    val schedule: Map<String, Map<String, Map<String, List<Map<String, String>>>>>? = null
) : Parcelable

