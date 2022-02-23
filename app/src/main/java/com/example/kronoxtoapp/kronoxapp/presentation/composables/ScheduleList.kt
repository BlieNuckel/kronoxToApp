package com.example.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.View
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.rememberScaffoldState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.presentation.preview.SampleDataProvider
import com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist.ScheduleListFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun ScheduleList(
    loading: Boolean,
    schedules: List<Any>,
    navController: NavController
){
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var toTopVisible = false
    val coroutineScope = rememberCoroutineScope()
    val scrollToTop: () -> Unit = {
        coroutineScope.launch {
            listState.scrollToItem(0)
        }
    }

    /* Used to remember state of scaffold during execution of program */

    /*Scaffold(
        scaffoldState = state
    ){

    }*/

    if (listState.firstVisibleItemIndex > 2) {
        toTopVisible = true
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            state = listState
        ){
            itemsIndexed(
                items = schedules
            ){ _, schedule ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if(schedule is DayDivider){
                        DayDividerUI(
                            dayName = schedule.dayName,
                            date = schedule.date
                        )
                    }else{
                        ScheduleCard(
                            schedule = schedule as ScheduleDetails,
                            onClick = {
                                if(schedule.course != null){
                                    val bundle = Bundle()
                                    bundle.putParcelable("schedule", schedule)
                                    navController.navigate(R.id.scheduleFragment, bundle)
                                }
                            })
                    }
                }
            }
        }
        CircularProgressBar(
            isDisplayed = loading
        )

        AnimatedVisibility(
            visible = toTopVisible,
            enter = slideInHorizontally(animationSpec = tween(durationMillis = 600)) { fullWidth ->
                fullWidth * 4
            } + fadeIn(animationSpec = tween(durationMillis = 600)),
            exit = slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessLow)) {
                300
            } + fadeOut(),
            modifier = Modifier
                .padding(end = 30.dp, bottom = 60.dp)
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