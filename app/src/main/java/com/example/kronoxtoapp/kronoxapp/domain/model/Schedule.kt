package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**** This is the model used to remap the JSON object of a chosen schedule ****/
@Parcelize
data class Schedule(
    val schedule: Map<String, Map<String, Map<String, List<Map<String, String>>>>>? = null
) : Parcelable