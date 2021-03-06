package com.tumble.kronoxtoapp.kronoxapp.presentation.composables

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.domain.model.AvailableProgram

/**** The compose view that shows all the available programs returned from a user search ****/
@Composable
fun AvailableProgramsList(
    loading: Boolean,
    availableSchedules: List<AvailableProgram>,
    navController: NavController,
    hasInternet: () -> Boolean
){
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        LazyColumn{
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
                            if(hasInternet()) {
                                val handler = Handler(Looper.getMainLooper())
                                handler.postDelayed({
                                    val bundle = Bundle()
                                    bundle.putParcelable("scheduleId", schedule)
                                    navController.navigate(R.id.scheduleListFragment, bundle)
                                }, 100)
                            }else{
                                Toast.makeText(context, "No internet connection",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                    if (index != availableSchedules.size - 1) {
                        Divider(
                            thickness = 1.dp,
                            color = MaterialTheme.colors.secondary,
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

        /**** Top page fade ****/
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.background,
                            Color.Transparent
                        )
                    )
                )
                .align(Alignment.TopCenter)
        )

        /**** Bottom page fade ****/
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background
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