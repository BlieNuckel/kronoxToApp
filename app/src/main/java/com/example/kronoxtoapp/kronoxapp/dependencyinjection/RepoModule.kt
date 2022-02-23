package com.example.kronoxtoapp.kronoxapp.dependencyinjection

import com.example.kronoxtoapp.kronoxapp.network.util.ScheduleService
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.example.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTOMapper
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    /**** Provides injection of RepoModule, used in ScheduleListViewModel and SearchMenuViewModel ****/
    @Singleton
    @Provides
    fun provideScheduleRepo(
        scheduleService: ScheduleService,
        scheduleDTOMapper: ScheduleDTOMapper,
        scheduleInfoDTOMapper: ScheduleInfoDTOMapper
    ): ScheduleRepo{
            return ScheduleRepoImplementation( scheduleService,
                scheduleDTOMapper, scheduleInfoDTOMapper )
    }


    /**** These parameters are injected into each viewmodel where we query ****/
    @Singleton
    @Provides
    @Named("year")
    fun provideYear(): String{
        return "*"
    }
    @Singleton
    @Provides
    @Named("month")
    fun provideMonth(): String{
        return "*"
    }
    @Singleton
    @Provides
    @Named("day")
    fun provideDay(): String{
        return "*"
    }
    @Singleton
    @Provides
    @Named("requestedSchedule")
    fun provideSchedule(): String{
        return "requestedSchedule"
    }
}