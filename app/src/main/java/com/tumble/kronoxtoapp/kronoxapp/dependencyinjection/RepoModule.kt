package com.tumble.kronoxtoapp.kronoxapp.dependencyinjection

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.network.util.ScheduleService
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTOMapper
import com.tumble.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import com.tumble.kronoxtoapp.kronoxapp.repo.ScheduleRepoImplementation
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


    /**** Provides Navigation controller between fragments ****/
    @Provides
    fun provideNavController(activity: Activity): NavController{
        return activity.findNavController(R.id.schedule_nav_host_fragment)
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