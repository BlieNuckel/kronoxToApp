package com.tumble.kronoxtoapp.kronoxapp.repo

import androidx.lifecycle.LiveData
import com.tumble.kronoxtoapp.kronoxapp.caching.ScheduleDAO
import com.tumble.kronoxtoapp.kronoxapp.caching.ScheduleDetailedModel

class ScheduleDetailsRepo(
    private val scheduleDao: ScheduleDAO
    )
{
    suspend fun insertSchedules(scheduleDetailedModel: ScheduleDetailedModel) =
        scheduleDao.insertSchedule(scheduleDetailedModel)

    suspend fun updateSchedules(scheduleDetailedModel: ScheduleDetailedModel) =
        scheduleDao.updateSchedule(scheduleDetailedModel)

    suspend fun deleteSchedules(scheduleDetailedModel: ScheduleDetailedModel) =
        scheduleDao.deleteSchedule(scheduleDetailedModel)

    fun getAllNotes(): LiveData<List<ScheduleDetailedModel>> = scheduleDao.getAllSchedules()
}