package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kronoxtoapp.kronoxapp.domain.model.Schedule
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleCard
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.components.CircularProgressBar
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class ScheduleListFragment : Fragment(){

    /* If we want to share a viewmodel between multiple fragments we need to
    * use 'activityViewModels()' instead of 'viewModels()' */
    private val viewModel: ScheduleListViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply{
            setContent{

                val schedules = viewModel.schedules.value

                val loading = viewModel.loading.value

                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    LazyColumn{
                        itemsIndexed(
                            items = schedules
                        ){ _, schedule ->
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                ScheduleCard(schedule = schedule, onClick = {})
                            }
                        }
                    }
                    CircularProgressBar(
                        isDisplayed = loading
                    )
                }
            }
        }
    }
}