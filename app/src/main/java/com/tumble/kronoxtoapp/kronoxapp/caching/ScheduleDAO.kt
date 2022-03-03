package com.tumble.kronoxtoapp.kronoxapp.caching

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ScheduleDAO {

    @Insert
    suspend fun insertSchedule(scheduleModel: ScheduleDetailedModel)

    @Update
    suspend fun updateSchedule(scheduleModel: ScheduleDetailedModel)

    @Query("SELECT * FROM schedule_data_table")
    fun getAllSchedules(): LiveData<List<ScheduleDetailedModel>>

    @Delete
    suspend fun deleteSchedule(scheduleModel: ScheduleDetailedModel)

}