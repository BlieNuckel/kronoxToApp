package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import android.os.Bundle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.ui.search.SearchViewModel

@Composable
fun AvailableProgramsList(
    loading: Boolean,
    availableSchedules: List<AvailableProgram>,
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        LazyColumn() {
            itemsIndexed(
                items = availableSchedules
            ){ index, schedule ->

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (index == 0) {
                        Spacer(Modifier.height(20.dp))
                    }
                    ProgramCard(
                        schedule = schedule,
                        onClick = {
                            val bundle = Bundle()
                            bundle.putParcelable("scheduleId", schedule)
                            navController.navigate(R.id.scheduleListFragment, bundle)
                        }
                    )

                    if (index != availableSchedules.size - 1) {
                        Divider(
                            thickness = 1.dp,
                            color = Color(android.graphics.Color.parseColor("#" + "e6e6e6")),
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
                        )
                    }
                    
                    if (index == availableSchedules.size - 1) {
                        Spacer(Modifier.height(20.dp))
                    }
                }

            }
        }

        // Top fade
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            Color.Transparent
                        )
                    )
                )
                .align(Alignment.TopCenter)
        )

        // Bottom fade
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )

        CircularProgressBar(
            isDisplayed = loading
        )
    }
}