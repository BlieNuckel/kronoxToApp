package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AndroidUiDispatcher.Companion.Main
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleCard
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleDetailsCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ScheduleFragment : Fragment(){

    private var schedule: ScheduleDetails? = null
    private var start: String? = null
    private var end: String? = null
    private var course: String? = null
    private var lecturer: String? = null
    private var location: String? = null
    private var title: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<ScheduleDetails>("schedule").let {
            schedule = it
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* This is the view model for the details about a specific days schedule,
        *  when you press the list item you will come here */
        return ComposeView(requireContext()).apply {
            setContent {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.White)
                ){
                    schedule?.let {
                        ScheduleDetailsCard(
                            schedule = it
                        ) {

                        }
                    }
                }
            }
        }
    }
}