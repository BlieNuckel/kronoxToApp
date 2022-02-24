package com.example.kronoxtoapp.kronoxapp.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(end = 5.dp)
        ) {
           Icon(
               Icons.Outlined.Settings,
               contentDescription = null,
               tint = Color(android.graphics.Color.parseColor("#" + "707070")),
               modifier = Modifier
                   .scale(1.2f)
                   .align(Alignment.CenterVertically)
           )
        }
    }
}