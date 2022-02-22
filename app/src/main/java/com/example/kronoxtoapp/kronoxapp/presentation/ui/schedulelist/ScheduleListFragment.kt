package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.kronoxapp.presentation.components.CustomDropDown
import com.example.kronoxtoapp.kronoxapp.presentation.components.ScheduleList
import com.example.kronoxtoapp.kronoxapp.presentation.components.TopBar
import com.example.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

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

                val temp = remember { mutableStateOf("") }

                AppTheme {
                    TextField(value = temp.value, onValueChange = {
                        viewModel.onQueryChanged(it)
                    })
                    Box(
                        modifier = Modifier.background(Color.White)
                    ){
                        val schedules = viewModel.schedules.value
                        val loading = viewModel.loading.value

                        ScheduleList(
                            loading = loading,
                            schedules = schedules,
                            navController = findNavController()
                        )
                    }
                }
            }
        }
    }
}