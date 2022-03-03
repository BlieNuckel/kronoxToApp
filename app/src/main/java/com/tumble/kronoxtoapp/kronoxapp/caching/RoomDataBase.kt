package com.tumble.kronoxtoapp.kronoxapp.caching

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [ScheduleDetailedModel::class],
    version = 1
)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun scheduleDAO(): ScheduleDAO

    companion object{
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): RoomDatabase? {
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "room_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}