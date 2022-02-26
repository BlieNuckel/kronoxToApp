package com.tumble.kronoxtoapp.kronoxapp.presentation.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.tumble.kronoxtoapp.kronoxapp.presentation.composables.AvailableProgramsList
import com.tumble.kronoxtoapp.kronoxapp.presentation.composables.ProgrammeSearchBar
import com.tumble.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMenuFragment: Fragment() {
    private val viewModel: SearchMenuViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    if(viewModel.hasFavorite())findNavController().navigate(R.id.scheduleListFragment)
                    val availablePrograms: List<AvailableProgram> =
                        viewModel.listOfAvailablePrograms.value
                    val loading = viewModel.loading.value
                    val liftMenu = viewModel.liftMenu.value
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        AnimatedVisibility(visible = !liftMenu) {
                            Spacer(modifier = Modifier.height(350.dp))
                        }
                        ProgrammeSearchBar(
                            setQueryValue = viewModel::setQueryValue,
                            getSearch = viewModel::getSearch,
                            getQueryValue = viewModel::getQueryValue,
                            onQueryChanged = viewModel::onQueryChanged
                            )

                            AvailableProgramsList(
                                loading = loading,
                                availableSchedules = availablePrograms,
                                navController = findNavController(),
                                hasInternet = viewModel::hasInternet
                            )

                    }
                }
            }
        }
    }
}