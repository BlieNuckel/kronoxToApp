package com.example.kronoxtoapp.kronoxapp.DependencyInjection

import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideScheduleRepo(
        scheduleService: ScheduleService, scheduleDTOMapper: ScheduleDTOMapper): ScheduleRepo{
        return ScheduleRepoImplementation(
            scheduleService, scheduleDTOMapper
        )
    }
}