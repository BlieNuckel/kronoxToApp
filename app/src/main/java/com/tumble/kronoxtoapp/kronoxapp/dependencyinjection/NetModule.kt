package com.tumble.kronoxtoapp.kronoxapp.dependencyinjection

import com.tumble.kronoxtoapp.kronoxapp.network.util.ScheduleService
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleDTOMapper
import com.tumble.kronoxtoapp.kronoxapp.network.model.ScheduleInfoDTOMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**** Allows injection inside viewmodels and also field injection ****/
@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Singleton
    @Provides
    fun provideScheduleMapper(): ScheduleDTOMapper {
        return ScheduleDTOMapper()
    }

    @Singleton
    @Provides
    fun provideScheduleInfoMapper(): ScheduleInfoDTOMapper{
        return ScheduleInfoDTOMapper()
    }

    /**** Allows for injection of schedules into viewmodels. This object exists only for the
    * lifespan of the application. ****/
    @Singleton
    @Provides
    fun provideScheduleService(): ScheduleService {
        return Retrofit.Builder()
            .baseUrl("https://kronox-app-backend.herokuapp.com/")
            .client(OkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleService::class.java)
    }
}