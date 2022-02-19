package com.example.kronoxtoapp.kronoxapp.domain.model

import android.os.Parcelable
import com.example.kronoxtoapp.kronoxapp.network.model.DaysDTO
import kotlinx.parcelize.Parcelize

@Parcelize
data class Year(

    val january: Map<String, DaysDTO?>? = null,
    val february: Map<String, DaysDTO?>? = null,
    val march: Map<String, DaysDTO?>? = null,
    val april: Map<String, DaysDTO?>? = null,
    val may: Map<String, DaysDTO?>? = null,
    val june: Map<String, DaysDTO?>? = null,
    val july: Map<String, DaysDTO?>? = null,
    val august: Map<String, DaysDTO?>? = null,
    val september: Map<String, DaysDTO?>? = null,
    val october: Map<String, DaysDTO?>? = null,
    val november: Map<String, DaysDTO?>? = null,
    val december: Map<String, DaysDTO?>? = null,

    ) : Parcelable