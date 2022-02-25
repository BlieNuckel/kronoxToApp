package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.presentation.composables.BottomBar
import com.example.kronoxtoapp.kronoxapp.presentation.composables.ScheduleList
import com.example.kronoxtoapp.kronoxapp.presentation.composables.TopBar
import com.example.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**** The fragment for the list of schedules after a use has picked a program from the menu ****/
@AndroidEntryPoint
class ScheduleListFragment : Fragment(){
    private var chosenProgram: AvailableProgram? = null

    /***** If we want to share a viewmodel between multiple fragments we need to
    * use 'activityViewModels()' instead of 'viewModels()' *****/

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
                val listState = rememberLazyListState()
                var scrolledY: Int

                AppTheme {
                    val schedules = viewModel.schedules.value
                    val loading = viewModel.loading.value

                    Box() {
                        ScheduleList(
                            loading = loading,
                            schedules = schedules,
                            navController = findNavController(),
                            listState = listState
                        )

                        if(listState.firstVisibleItemIndex == 0) {
                            Box(
                                modifier = Modifier
                                    .graphicsLayer {
                                        if (listState.firstVisibleItemIndex < 1) {
                                            scrolledY = listState.firstVisibleItemScrollOffset
                                            translationY = -scrolledY.toFloat()
                                        }
                                    }
                            ) {
                                TopBar()
                                IconButton(
                                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                                    onClick = {
                                        CoroutineScope(IO).launch {
                                            viewModel.toggleFavorite()
                                        }
                                    }
                                )
                                {
                                    if(viewModel.onFavoriteSchedule.value){
                                        Icon(
                                            Icons.Filled.Star,
                                            contentDescription = null
                                        )
                                    }else{
                                        Icon(
                                            Icons.Outlined.Star,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                        BottomBar()
                    }
                }
            }
        }
    }
}