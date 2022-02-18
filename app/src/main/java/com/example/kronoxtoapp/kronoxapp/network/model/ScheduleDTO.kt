package com.example.kronoxtoapp.kronoxapp.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/* This is the data model that Retrofit uses to fetch data from
*  REST API.
*  It models what a schedule looks like coming from the network */

data class ScheduleDTO (
    @SerializedName("2022")
    val year: Months? = null,
)

@Parcelize
data class Months(
    @SerializedName("January")
    val january: Days? = null,
    @SerializedName("February")
    val february: Days? = null,
    @SerializedName("March")
    val march:Days? = null,
    @SerializedName("April")
    val april: Days? = null,
    @SerializedName("May")
    val may: Days? = null,
    @SerializedName("June")
    val june: Days? = null,
    @SerializedName("July")
    val july: Days? = null,
    @SerializedName("August")
    val august: Days? = null,
    @SerializedName("September")
    val september: Days? = null,
    @SerializedName("October")
    val october: Days? = null,
    @SerializedName("November")
    val november: Days? = null,
    @SerializedName("December")
    val december: Days? = null
) : Parcelable

@Parcelize
data class Days(
    /*TODO:
       I need to seriously find a better way to do this because this
    *  is just embarrassing. But for now each one of the days serves as an actual
    *  primary key in their table holding a value, so this is why it looks like this. */

    @SerializedName("1")
    val day_one: List<DetailsForDay>? = null,
    @SerializedName("2")
    val day_two: List<DetailsForDay>? = null,
    @SerializedName("3")
    val day_three: List<DetailsForDay>? = null,
    @SerializedName("4")
    val day_four: List<DetailsForDay>? = null,
    @SerializedName("5")
    val day_five: List<DetailsForDay>? = null,
    @SerializedName("6")
    val day_six: List<DetailsForDay>? = null,
    @SerializedName("7")
    val day_seven: List<DetailsForDay>? = null,
    @SerializedName("8")
    val day_eight: List<DetailsForDay>? = null,
    @SerializedName("9")
    val day_nine: List<DetailsForDay>? = null,
    @SerializedName("10")
    val day_ten: List<DetailsForDay>? = null,
    @SerializedName("11")
    val day_eleven: List<DetailsForDay>? = null,
    @SerializedName("12")
    val day_twelve: List<DetailsForDay>? = null,
    @SerializedName("13")
    val day_thirteen: List<DetailsForDay>? = null,
    @SerializedName("14")
    val day_fourteen: List<DetailsForDay>? = null,
    @SerializedName("15")
    val day_fifteen: List<DetailsForDay>? = null,
    @SerializedName("16")
    val day_sixteen: List<DetailsForDay>? = null,
    @SerializedName("17")
    val day_seventeen: List<DetailsForDay>? = null,
    @SerializedName("18")
    val day_eighteen: List<DetailsForDay>? = null,
    @SerializedName("19")
    val day_nineteen: List<DetailsForDay>? = null,
    @SerializedName("20")
    val day_twenty: List<DetailsForDay>? = null,
    @SerializedName("21")
    val day_twenty_one: List<DetailsForDay>? = null,
    @SerializedName("22")
    val day_twenty_two: List<DetailsForDay>? = null,
    @SerializedName("23")
    val day_twenty_three: List<DetailsForDay>? = null,
    @SerializedName("24")
    val day_twenty_four: List<DetailsForDay>? = null,
    @SerializedName("25")
    val day_twenty_five: List<DetailsForDay>? = null,
    @SerializedName("26")
    val day_twenty_six: List<DetailsForDay>? = null,
    @SerializedName("27")
    val day_twenty_seven: List<DetailsForDay>? = null,
    @SerializedName("28")
    val day_twenty_eight: List<DetailsForDay>? = null,
    @SerializedName("29")
    val day_twenty_nine: List<DetailsForDay>? = null,
    @SerializedName("30")
    val day_thirty: List<DetailsForDay>? = null,
    @SerializedName("31")
    val day_thirty_one: List<DetailsForDay>? = null
): Parcelable


@Parcelize
data class DetailsForDay(
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