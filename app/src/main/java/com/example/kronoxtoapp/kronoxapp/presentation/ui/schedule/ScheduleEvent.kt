package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule

sealed class ScheduleEvent {
    data class GetScheduleEvent(
        val id: String? = null
    ): ScheduleEvent()
}