package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/* This is the data model that Retrofit uses to fetch data from
*  REST API.
*  It models what a schedule looks like coming from the network */

@Parcelize
data class ScheduleDTO (
    @SerializedName("2022")
    val year: MonthsDTO? = null
): Parcelable

@Parcelize
data class MonthsDTO(
    @SerializedName("January")
    val january: DaysDTO? = null,
    @SerializedName("February")
    val february: DaysDTO? = null,
    @SerializedName("March")
    val march:DaysDTO? = null,
    @SerializedName("April")
    val april: DaysDTO? = null,
    @SerializedName("May")
    val may: DaysDTO? = null,
    @SerializedName("June")
    val june: DaysDTO? = null,
    @SerializedName("July")
    val july: DaysDTO? = null,
    @SerializedName("August")
    val august: DaysDTO? = null,
    @SerializedName("September")
    val september: DaysDTO? = null,
    @SerializedName("October")
    val october: DaysDTO? = null,
    @SerializedName("November")
    val november: DaysDTO? = null,
    @SerializedName("December")
    val december: DaysDTO? = null
) : Parcelable

@Parcelize
data class DaysDTO(
    /*TODO:
       I need to seriously find a better way to do this because this
    *  is just embarrassing. But for now each one of the days serves as an actual
    *  primary key in their table holding a value, so this is why it looks like this. */

    @SerializedName("1")
    val day_one: List<DayDetails>? = null,
    @SerializedName("2")
    val day_two: List<DayDetails>? = null,
    @SerializedName("3")
    val day_three: List<DayDetails>? = null,
    @SerializedName("4")
    val day_four: List<DayDetails>? = null,
    @SerializedName("5")
    val day_five: List<DayDetails>? = null,
    @SerializedName("6")
    val day_six: List<DayDetails>? = null,
    @SerializedName("7")
    val day_seven: List<DayDetails>? = null,
    @SerializedName("8")
    val day_eight: List<DayDetails>? = null,
    @SerializedName("9")
    val day_nine: List<DayDetails>? = null,
    @SerializedName("10")
    val day_ten: List<DayDetails>? = null,
    @SerializedName("11")
    val day_eleven: List<DayDetails>? = null,
    @SerializedName("12")
    val day_twelve: List<DayDetails>? = null,
    @SerializedName("13")
    val day_thirteen: List<DayDetails>? = null,
    @SerializedName("14")
    val day_fourteen: List<DayDetails>? = null,
    @SerializedName("15")
    val day_fifteen: List<DayDetails>? = null,
    @SerializedName("16")
    val day_sixteen: List<DayDetails>? = null,
    @SerializedName("17")
    val day_seventeen: List<DayDetails>? = null,
    @SerializedName("18")
    val day_eighteen: List<DayDetails>? = null,
    @SerializedName("19")
    val day_nineteen: List<DayDetails>? = null,
    @SerializedName("20")
    val day_twenty: List<DayDetails>? = null,
    @SerializedName("21")
    val day_twenty_one: List<DayDetails>? = null,
    @SerializedName("22")
    val day_twenty_two: List<DayDetails>? = null,
    @SerializedName("23")
    val day_twenty_three: List<DayDetails>? = null,
    @SerializedName("24")
    val day_twenty_four: List<DayDetails>? = null,
    @SerializedName("25")
    val day_twenty_five: List<DayDetails>? = null,
    @SerializedName("26")
    val day_twenty_six: List<DayDetails>? = null,
    @SerializedName("27")
    val day_twenty_seven: List<DayDetails>? = null,
    @SerializedName("28")
    val day_twenty_eight: List<DayDetails>? = null,
    @SerializedName("29")
    val day_twenty_nine: List<DayDetails>? = null,
    @SerializedName("30")
    val day_thirty: List<DayDetails>? = null,
    @SerializedName("31")
    val day_thirty_one: List<DayDetails>? = null
): Parcelable


@Parcelize
data class DayDetails(
    @SerializedName("start")
    val start: String? = null,

    @SerializedName("end")
    val end: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("description")
    val desc: String? = null,

    @SerializedName("lecturer")
    val lecturer: String? = null,

    @SerializedName("location")
    val location: String? = null,

    @SerializedName("course")
    val course: String? = null
) : Parcelable