package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist.ScheduleListViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**** The compose view of the entire list of Schedule cards ****/
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScheduleList(
    loading: Boolean,
    schedules: List<Any>,
    navController: NavController,
    listState: LazyListState,
    showScrollToTop: MutableState<Boolean>
){
    val coroutineScope = rememberCoroutineScope()
    val scrollToTop: () -> Unit = remember {
        {
            coroutineScope.launch {
                listState.scrollToItem(0)
            }
        }
    }
    LaunchedEffect(listState.isScrollInProgress) {
        this.launch {
            if (listState.firstVisibleItemIndex > 2) {
                showScrollToTop.value = false
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ){

        CompositionLocalProvider(
            LocalOverScrollConfiguration provides null
        ) {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(top = 26.dp, bottom = 70.dp)
            ){
                items(items = schedules, itemContent = { item ->
                    when(item) {
                        is DayDivider -> {
                            DayDividerUI(
                                dayName = item.dayName,
                                date = item.date
                            )
                        }
                        is ScheduleDetails -> {
                            ScheduleCard(
                                schedule = item,
                                onClick = {
                                    if(item.course != null){
                                        val bundle = Bundle()
                                        bundle.putParcelable("schedule", item)
                                        navController.navigate(R.id.scheduleFragment, bundle)
                                    }
                                }
                            )
                        }
                    }
                })
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

        CircularProgressBar(
            isDisplayed = loading
        )

        AnimatedVisibility(
            visible = showScrollToTop.value,
            enter = slideInHorizontally(animationSpec = tween(durationMillis = 600)) { fullWidth ->
                fullWidth * 4
            } + fadeIn(animationSpec = tween(durationMillis = 600)),
            exit = slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessLow)) {
                300
            } + fadeOut(),
            modifier = Modifier
                .padding(end = 30.dp, bottom = 120.dp)
                .align(Alignment.BottomEnd)
        ) {
            Card(
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable { scrollToTop() },
                elevation = 2.dp
            ) {
                Column() {
                    Box(modifier = Modifier
                        .height(22.dp)
                        .width(22.dp)
                        .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_to_top),
                            contentDescription = null
                        )
                    }

                    Text(
                        text = "TOP",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }


    }
}