package com.tumble.kronoxtoapp.kronoxapp.caching

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ScheduleListCache::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleDAO(): ScheduleDAO
}