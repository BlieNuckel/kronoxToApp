package com.tumble.kronoxtoapp.kronoxapp.caching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tumble.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import java.time.ZonedDateTime

@Entity(tableName = "schedule_data_table")
data class ScheduleListCache(
    @PrimaryKey(autoGenerate = true)
    val scheduleId: Int?,
    @ColumnInfo
    val scheduleList: List<ScheduleDetails>
)
