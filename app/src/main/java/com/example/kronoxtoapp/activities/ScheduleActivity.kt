package com.example.kronoxtoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.network.ScheduleService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout .schedule_activity)

        val service = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleService::class.java)

        CoroutineScope(IO).launch{
            val schedule = service.get(
                token = "API TOKEN HERE",
                id = 2022
            )
            Log.d("ScheduleActivity", "onCreate: $schedule")
        }
    }
}