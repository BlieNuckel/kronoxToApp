package com.tumble.kronoxtoapp.kronoxapp.repo

import com.tumble.kronoxtoapp.kronoxapp.caching.ScheduleDAO
import javax.inject.Inject

class DatabaseImplementation
@Inject
constructor(
    private val scheduleDAO: ScheduleDAO
)
{
}