package com.example.kronoxtoapp.kronoxapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.network.ScheduleService
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout .schedule_activity)

        val service = Retrofit.Builder()
            .baseUrl("https://kronox-app-backend.herokuapp.com/schedules/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleService::class.java)

        /* Background thread */
        CoroutineScope(IO).launch{
            val schedule = service.get("2022", "march", "*")

            Log.d("AppDebug", schedule.toString())
        }
    }
}