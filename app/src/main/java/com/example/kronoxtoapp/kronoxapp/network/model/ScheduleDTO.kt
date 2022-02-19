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
    val day_one: List<DayDetailsDTO>? = null,
    @SerializedName("2")
    val day_two: List<DayDetailsDTO>? = null,
    @SerializedName("3")
    val day_three: List<DayDetailsDTO>? = null,
    @SerializedName("4")
    val day_four: List<DayDetailsDTO>? = null,
    @SerializedName("5")
    val day_five: List<DayDetailsDTO>? = null,
    @SerializedName("6")
    val day_six: List<DayDetailsDTO>? = null,
    @SerializedName("7")
    val day_seven: List<DayDetailsDTO>? = null,
    @SerializedName("8")
    val day_eight: List<DayDetailsDTO>? = null,
    @SerializedName("9")
    val day_nine: List<DayDetailsDTO>? = null,
    @SerializedName("10")
    val day_ten: List<DayDetailsDTO>? = null,
    @SerializedName("11")
    val day_eleven: List<DayDetailsDTO>? = null,
    @SerializedName("12")
    val day_twelve: List<DayDetailsDTO>? = null,
    @SerializedName("13")
    val day_thirteen: List<DayDetailsDTO>? = null,
    @SerializedName("14")
    val day_fourteen: List<DayDetailsDTO>? = null,
    @SerializedName("15")
    val day_fifteen: List<DayDetailsDTO>? = null,
    @SerializedName("16")
    val day_sixteen: List<DayDetailsDTO>? = null,
    @SerializedName("17")
    val day_seventeen: List<DayDetailsDTO>? = null,
    @SerializedName("18")
    val day_eighteen: List<DayDetailsDTO>? = null,
    @SerializedName("19")
    val day_nineteen: List<DayDetailsDTO>? = null,
    @SerializedName("20")
    val day_twenty: List<DayDetailsDTO>? = null,
    @SerializedName("21")
    val day_twenty_one: List<DayDetailsDTO>? = null,
    @SerializedName("22")
    val day_twenty_two: List<DayDetailsDTO>? = null,
    @SerializedName("23")
    val day_twenty_three: List<DayDetailsDTO>? = null,
    @SerializedName("24")
    val day_twenty_four: List<DayDetailsDTO>? = null,
    @SerializedName("25")
    val day_twenty_five: List<DayDetailsDTO>? = null,
    @SerializedName("26")
    val day_twenty_six: List<DayDetailsDTO>? = null,
    @SerializedName("27")
    val day_twenty_seven: List<DayDetailsDTO>? = null,
    @SerializedName("28")
    val day_twenty_eight: List<DayDetailsDTO>? = null,
    @SerializedName("29")
    val day_twenty_nine: List<DayDetailsDTO>? = null,
    @SerializedName("30")
    val day_thirty: List<DayDetailsDTO>? = null,
    @SerializedName("31")
    val day_thirty_one: List<DayDetailsDTO>? = null
): Parcelable


@Parcelize
data class DayDetailsDTO(
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