package com.tumble.kronoxtoapp.kronoxapp.caching

import androidx.room.*
import com.tumble.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails

@Dao
interface ScheduleDAO {

    @Insert
    suspend fun insertSchedule(scheduleModel: List<ScheduleDetails>)

    @Update
    suspend fun updateSchedule(scheduleModel: List<ScheduleDetails>)

    @Query("SELECT * FROM schedule_data_table")
    fun getAllSchedules(): List<List<ScheduleDetails>>

    @Delete
    suspend fun deleteSchedule(scheduleModel: List<ScheduleDetails>)

}