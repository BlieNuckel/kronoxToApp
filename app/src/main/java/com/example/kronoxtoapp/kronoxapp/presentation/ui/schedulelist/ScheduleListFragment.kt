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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
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

                    Column(
                        modifier = Modifier.background(Color.White)
                    ){

                        TopAppBar(
                            backgroundColor = Color.White,
                            title = {
                                Text(text = "Title")
                            },
                            actions = {

                                var menuExpanded by remember { mutableStateOf(false) }

                                IconButton(onClick = { menuExpanded = true }) {
                                    Icon(Icons.Default.MoreVert, contentDescription = null)
                                }
                                DropdownMenu(
                                    expanded = menuExpanded,
                                    onDismissRequest = {
                                        menuExpanded = false
                                    },
                                ) {
                                    DropdownMenuItem(onClick = {}) {
                                        Text("Item 2")
                                    }
                                }
                            },
                            elevation = 20.dp
                        )

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