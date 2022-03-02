package com.tumble.kronoxtoapp.kronoxapp.presentation.ui.schedulelist


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.findNavController
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.tumble.kronoxtoapp.kronoxapp.presentation.composables.BottomBar
import com.tumble.kronoxtoapp.kronoxapp.presentation.composables.ScheduleList
import com.tumble.kronoxtoapp.kronoxapp.presentation.composables.TopBar
import com.tumble.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
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
                val schedules = viewModel.schedules.value
                val loading = viewModel.loading.value

                AppTheme {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                    ) {
                        ScheduleList(
                            loading = loading,
                            schedules = schedules,
                            navController = findNavController(),
                            listState = listState,
                            viewModel.showScrollToTop,
                            viewModel::isExamCard
                        )

                        AnimatedVisibility(
                            visible = listState.firstVisibleItemIndex == 0,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            Box() {
                                TopBar(navController = findNavController())

                                if (viewModel.foundSchedule()) {
                                    IconToggleButton(
                                        checked = viewModel.onFavoriteSchedule.value,
                                        modifier = Modifier
                                            .padding(start = 5.dp, top = 5.dp),
                                        onCheckedChange = {
                                            CoroutineScope(IO).launch {
                                                viewModel.toggleFavorite()
                                            }
                                        }
                                    ) {
                                        if(viewModel.onFavoriteSchedule.value){
                                            Icon(
                                                Icons.Filled.Favorite,
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .scale(1.2f),
                                                tint = MaterialTheme.colors.primary
                                            )
                                        }else{
                                            Icon(
                                                Icons.Outlined.FavoriteBorder,
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .scale(1.2f),
                                                tint = MaterialTheme.colors.onBackground
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        BottomBar(
                            scheduleActivePassed = viewModel.scheduleActive,
                            weekActivePassed = viewModel.weekActive,
                            yearActivePassed = viewModel.yearActive
                        )
                    }
                }
            }
        }
    }
}