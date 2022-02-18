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
            .baseUrl("https://kronox-app-backend.herokuapp.com/schedule/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleService::class.java)

        /* Background thread */
        CoroutineScope(IO).launch{
            val schedule = service.get("2022")
            schedule.year?.february?.day_eighteen?.get(0).let { info ->
                Log.d("ScheduleActivity",
                    "\nCourse: ${info?.course}\n" +
                            "Lecturer: ${info?.lecturer}\n " +
                            "Description: ${info?.desc}\n" +
                            "Location: ${info?.location}" +
                            "Title: ${info?.title}")
            }
        }
    }
}