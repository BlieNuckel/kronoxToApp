package com.example.kronoxtoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.activities.domain.model.Schedule
import com.example.kronoxtoapp.network.model.ScheduleNetworkMapper
import com.example.kronoxtoapp.network.model.ScheduleNetworker

class ScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout .schedule_activity)

        val mapper = ScheduleNetworkMapper()
        val schedule = Schedule()
        val networkEntity: ScheduleNetworker = mapper.mapToSchedule(schedule)

    }
}