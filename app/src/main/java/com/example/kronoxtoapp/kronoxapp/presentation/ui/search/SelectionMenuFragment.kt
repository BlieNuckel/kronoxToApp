package com.example.kronoxtoapp.kronoxapp.presentation.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.presentation.composables.AvailableProgramsList
import com.example.kronoxtoapp.kronoxapp.presentation.composables.ProgrammeSearchBar
import com.example.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectionMenuFragment: Fragment() {

    private val viewModel: SearchViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    var availablePrograms: List<AvailableProgram> = viewModel.listOfAvailablePrograms.value
                    val loading = viewModel.loading.value
                    var liftMenu = viewModel.liftMenu.value

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AnimatedVisibility(visible = !liftMenu) {
                            Spacer(modifier = Modifier.height(350.dp))
                        }

                        ProgrammeSearchBar(viewModel = viewModel)

                        AvailableProgramsList(
                            loading = loading,
                            availableSchedules = availablePrograms,
                            navController = findNavController()
                        )
                        
                    }
                }
            }
        }

    }
}