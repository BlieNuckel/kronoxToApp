package com.example.kronoxtoapp.kronoxapp.dependencyinjection

import android.content.Context
import com.example.kronoxtoapp.kronoxapp.datastorage.DataStorageImplementation
import com.example.kronoxtoapp.kronoxapp.datastorage.DataStoreRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext app: Context
    ): DataStoreRepo = DataStorageImplementation(app)
}