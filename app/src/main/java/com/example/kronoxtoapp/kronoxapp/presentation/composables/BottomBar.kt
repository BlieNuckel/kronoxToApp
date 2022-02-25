package com.example.kronoxtoapp.kronoxapp.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kronoxtoapp.R
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

@Composable
fun BottomBar(
    scheduleActivePassed: MutableState<Boolean>,
    weekActivePassed: MutableState<Boolean>,
    yearActivePassed: MutableState<Boolean>
) {
    val MAIN_COLOR = Color(android.graphics.Color.parseColor("#" + "707070"))
    val ACTIVE_COLOR = Color(android.graphics.Color.parseColor("#" + "212121"))
    val coroutineScope = rememberCoroutineScope()
    val scheduleActive = remember { scheduleActivePassed }
    val weekActive = remember { weekActivePassed }
    val yearActive = remember { yearActivePassed }

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .advancedShadow(
                    color = Color.Black,
                    offsetY = 2.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                IconToggleButton(
                    checked = scheduleActive.value,
                    onCheckedChange = {
                        coroutineScope.launch {
                            scheduleActive.value = true
                            weekActive.value = false
                            yearActive.value = false
                        }
                    },
                    interactionSource = remember { DisabledInteractionSource() },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (scheduleActive.value) {
                            Icon(
                                painter = painterResource(R.drawable.outline_calendar_view_day_24),
                                contentDescription = null,
                                tint = ACTIVE_COLOR
                            )

                            Text(
                                text = "Schedule",
                                color = ACTIVE_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.outline_calendar_view_day_24),
                                contentDescription = null,
                                tint = MAIN_COLOR
                            )

                            Text(
                                text = "Schedule",
                                color = MAIN_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W300
                            )
                        }
                    }
                }

                IconToggleButton(
                    checked = weekActive.value,
                    onCheckedChange = {
                        coroutineScope.launch {
                            scheduleActive.value = false
                            weekActive.value = true
                            yearActive.value = false
                        }
                    },
                    interactionSource = remember { DisabledInteractionSource() },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (weekActive.value) {
                            Icon(
                                painter = painterResource(R.drawable.outline_calendar_view_week_24),
                                contentDescription = null,
                                tint = ACTIVE_COLOR
                            )

                            Text(
                                text = "Week",
                                color = ACTIVE_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.outline_calendar_view_week_24),
                                contentDescription = null,
                                tint = MAIN_COLOR
                            )

                            Text(
                                text = "Week",
                                color = MAIN_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W300
                            )
                        }

                    }
                }

                IconToggleButton(
                    checked = yearActive.value,
                    onCheckedChange = {
                        coroutineScope.launch {
                            scheduleActive.value = false
                            weekActive.value = false
                            yearActive.value = true
                        }
                    },
                    interactionSource = remember { DisabledInteractionSource() },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (yearActive.value) {
                            Icon(
                                painter = painterResource(R.drawable.outline_date_range_24),
                                contentDescription = null,
                                tint = ACTIVE_COLOR
                            )

                            Text(
                                text = "Year",
                                color = ACTIVE_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.outline_date_range_24),
                                contentDescription = null,
                                tint = MAIN_COLOR
                            )

                            Text(
                                text = "Year",
                                color = MAIN_COLOR,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W300
                            )
                        }

                    }
                }
            }
        }
    }
}

fun Modifier.advancedShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = composed {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha= 0f).toArgb()

    this.drawBehind {

        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent

            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}

class DisabledInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true

}