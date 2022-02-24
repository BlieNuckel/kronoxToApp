package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.presentation.composables.ScheduleList
import com.example.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleListFragment : Fragment(){

    private var chosenProgram: AvailableProgram? = null

    /* If we want to share a viewmodel between multiple fragments we need to
    * use 'activityViewModels()' instead of 'viewModels()' */
    private val viewModel: ScheduleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<AvailableProgram>("scheduleId").let {
            chosenProgram = it
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply{
            setContent{
                AppTheme {
                    val schedules = viewModel.schedules.value
                    val loading = viewModel.loading.value

                    Box() {
                        ScheduleList(
                            loading = loading,
                            schedules = schedules,
                            navController = findNavController(),
                            viewModel = viewModel
                        )

                        AnimatedVisibility(
                            visible = viewModel.topBarVisible.value,
                            enter = slideInVertically(animationSpec = tween(durationMillis = 150)) { fullHeight ->
                                -fullHeight - 20
                            },
                            exit = slideOutVertically(animationSpec = tween(durationMillis = 150)) { fullHeight ->
                                -fullHeight - 20
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Surface(
                                modifier = Modifier
                                    .height(60.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter),
                                elevation = 5.dp
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Schedule",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.W300,
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                    )

                                    val splitTitle = chosenProgram?.scheduleName.toString().split(" ")

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 15.dp),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Text(
                                            text = splitTitle[0],
                                            fontWeight = FontWeight.W200,
                                            fontSize = 16.sp
                                        )
                                        Text(
                                            text = splitTitle[1],
                                            fontWeight = FontWeight.W200,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}