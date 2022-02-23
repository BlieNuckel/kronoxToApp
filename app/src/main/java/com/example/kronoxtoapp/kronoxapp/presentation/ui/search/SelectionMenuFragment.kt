package com.example.kronoxtoapp.kronoxapp.presentation.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kronoxtoapp.kronoxapp.datastorage.StoreUserSchedule
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.presentation.composables.AvailableProgramsList
import com.example.kronoxtoapp.kronoxapp.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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

                val query = viewModel.query.value
                var availablePrograms: List<AvailableProgram>

                AppTheme {
                    Column(
                        modifier = Modifier.background(Color.White)
                    ) {
                        TopAppBar(
                            modifier = Modifier
                                .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                                .height(75.dp),
                            backgroundColor = Color.White,
                            title = {
                                Text(
                                    text = query
                                )
                            },
                            actions = {
                                Row(
                                ){
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .padding(8.dp)
                                            .background(
                                                color = MaterialTheme.colors.surface.copy(
                                                    alpha = 0.3f
                                                )
                                            ),
                                        value = query,
                                        onValueChange = {
                                            viewModel.onQueryChanged(it)
                                        },
                                        label = {
                                            Text(
                                                text = "Search schedule"
                                            )
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Search
                                        ),
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        viewModel.getSearch(query)
                                    }
                                ) {
                                    Icon(Icons.Outlined.ArrowForward, contentDescription = null)
                                }
                            },
                        )

                        availablePrograms = viewModel.listOfAvailablePrograms.value
                        val loading = viewModel.loading.value

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