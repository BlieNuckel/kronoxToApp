package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.example.kronoxtoapp.kronoxapp.presentation.composables.ScheduleList
import com.example.kronoxtoapp.kronoxapp.presentation.ui.UIdata
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

                val listOfPrograms = listOf("TGDU3", "SGGS2")
                var selectedText by remember { mutableStateOf("Select a schedule") }
                val mapOfPrograms = mapOf("SGGS2" to "p.SGGS2+2021+35+100+NML+sv",
                    "TGDU3" to "p.TBSE2+2021+35+100+NML+en")

                AppTheme {
                    Column(
                        modifier = Modifier.background(Color.White)
                    ){
                        TopAppBar(
                            modifier = Modifier.padding(top = 10.dp, start = 20.dp, end = 20.dp),
                            backgroundColor = Color.White,
                            title = {
                                Text(
                                    text = selectedText
                                )
                            },
                            actions = {

                                var menuExpanded by remember { mutableStateOf(false) }

                                IconButton(
                                    onClick = { menuExpanded = true }
                                ) {
                                    Icon(Icons.Default.MoreVert, contentDescription = null)
                                }
                                DropdownMenu(
                                    expanded = menuExpanded,
                                    onDismissRequest = {
                                        menuExpanded = false
                                    },
                                ) {
                                    listOfPrograms.forEach { label ->
                                        DropdownMenuItem(onClick = {
                                            selectedText = label
                                            menuExpanded = false
                                            mapOfPrograms[selectedText]
                                                ?.let { viewModel.onQueryChanged(it) }
                                            viewModel.newGet(viewModel.id.value)

                                        }) {
                                            Text(text = label)
                                        }
                                    }
                                }
                            },
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