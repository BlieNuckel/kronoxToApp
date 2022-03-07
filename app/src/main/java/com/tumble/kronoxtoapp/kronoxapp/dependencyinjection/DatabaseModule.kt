package com.tumble.kronoxtoapp.kronoxapp.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.tumble.kronoxtoapp.kronoxapp.caching.AppDatabase
import com.tumble.kronoxtoapp.kronoxapp.caching.ScheduleDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideChannelDao(roomDataBase: AppDatabase): ScheduleDAO {
        return roomDataBase.scheduleDAO()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).build()
    }
}