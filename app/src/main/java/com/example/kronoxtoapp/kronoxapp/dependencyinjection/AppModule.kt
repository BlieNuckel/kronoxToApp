package com.example.kronoxtoapp.kronoxapp.dependencyinjection

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.presentation.BaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    /**** This function is used to retrieve activity context from any fragment ****/
    @Singleton
    @Provides
    @Named("BaseApp")
    fun provideApplication(@ApplicationContext app: Context): BaseApp {
        return app as BaseApp
    }
}