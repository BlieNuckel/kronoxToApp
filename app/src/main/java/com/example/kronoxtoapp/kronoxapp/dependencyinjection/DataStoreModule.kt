package com.example.kronoxtoapp.kronoxapp.dependencyinjection

import android.content.Context
import com.example.kronoxtoapp.kronoxapp.repo.DataStorageImplementation
import com.example.kronoxtoapp.kronoxapp.repo.DataStoreRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**** Provides the DataStoreRepository inside of ScheduleListViewModel and ScheduleMenuViewModel ****/
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext app: Context
    ): DataStoreRepo = DataStorageImplementation(app)
}