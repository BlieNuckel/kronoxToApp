package com.tumble.kronoxtoapp.kronoxapp.caching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "schedule_data_table")
data class ScheduleDetailedModel(
    @PrimaryKey(autoGenerate = true)
    val scheduleId: Int?,
    @ColumnInfo(name = "schedule_start")
    var start: ZonedDateTime,
    @ColumnInfo(name = "schedule_end")
    var end: ZonedDateTime,
    @ColumnInfo(name = "schedule_course")
    var course: String,
    @ColumnInfo(name = "schedule_lecturer")
    var lecturer: String,
    @ColumnInfo(name = "schedule_location")
    var location: String,
    @ColumnInfo(name = "schedule_title")
    var title: String,
    @ColumnInfo(name = "schedule_color")
    var color: String
)
