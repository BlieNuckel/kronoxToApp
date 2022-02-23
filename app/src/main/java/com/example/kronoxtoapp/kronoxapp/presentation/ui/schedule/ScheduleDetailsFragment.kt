package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedule

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.composables.ScheduleDetailsCard
import dagger.hilt.android.AndroidEntryPoint

/**** The fragment for details about a clicked schedule card in the ScheduleListFragment ****/
@AndroidEntryPoint
class ScheduleDetailsFragment : Fragment(){
    private var schedule: ScheduleDetails? = null
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

        /***** This is the view model for the details about a specific days schedule,
            *  when you press the list item you will come here *****/
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