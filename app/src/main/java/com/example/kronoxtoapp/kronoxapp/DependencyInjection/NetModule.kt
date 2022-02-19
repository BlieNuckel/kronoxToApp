package com.example.kronoxtoapp.kronoxapp.DependencyInjection

import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/* Allows injection inside viewmodels and also field injection */
@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Singleton
    @Provides
    fun provideScheduleMapper(): ScheduleDTOMapper {
        return ScheduleDTOMapper()
    }

    /* Allows for injection of schedules into viewmodels. This object exists only for the
    * lifespan of the application. */
    @Singleton
    @Provides
    fun provideScheduleService(): ScheduleService {
        return Retrofit.Builder()
            .baseUrl("https://kronox-app-backend.herokuapp.com/schedule/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleService::class.java)
    }

}