package com.example.kronoxtoapp.kronoxapp.DependencyInjection

import android.content.Context
import com.example.kronoxtoapp.kronoxapp.BaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides /* This function is used to retrieve activity context from anywhere */
    fun provideApplication(@ApplicationContext app: Context): BaseApp{
        return app as BaseApp
    }

    @Singleton
    @Provides
    fun provideRandomString(): String{
        return "random string"
    }
}