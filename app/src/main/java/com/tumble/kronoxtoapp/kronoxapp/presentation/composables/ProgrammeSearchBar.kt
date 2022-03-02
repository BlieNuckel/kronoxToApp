package com.tumble.kronoxtoapp.kronoxapp.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KSuspendFunction1


/**** The search bar displayed in SearchMenuFragment on startup ****/
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun ProgrammeSearchBar(
    setQueryValue: (String) -> Unit,
    getSearch: KSuspendFunction1<String, Unit>,
    getQueryValue: () -> String,
    onQueryChanged: (String) -> Unit,
    liftMenu: MutableState<Boolean>
) {
    val query = getQueryValue()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .padding(top = 50.dp, bottom = 5.dp)
    ) {
        Surface(
            elevation = 3.dp,
            shape = RoundedCornerShape(6.dp)
        ) {
            TextField(
                value = query,
                onValueChange = {
                    onQueryChanged(it)
                },
                placeholder = {
                    Text(
                        text = "Search schedules",
                        overflow = TextOverflow.Clip,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                shape = RoundedCornerShape(6.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    cursorColor = MaterialTheme.colors.primaryVariant,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onSearch = {
                        CoroutineScope(IO).launch{
                            getSearch(query)
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    }
                ),
                trailingIcon = {
                                AnimatedVisibility(
                                    visible = query != "",
                                    enter = fadeIn(),
                                    exit = fadeOut()
                                ) {
                                    IconButton(
                                        onClick = {setQueryValue("")},
                                        modifier = Modifier
                                            .scale(0.8f)
                                    ) {
                                        Icon(Icons.Outlined.Clear, contentDescription = null,)
                                    }
                                }
                },
                modifier = Modifier
                    .align(Alignment.Top)
                    .width(280.dp)
                    .onFocusChanged { focusState ->
                        liftMenu.value = focusState.hasFocus
                    }
            )
        }

        Surface(
            onClick = {
                CoroutineScope(IO).launch {
                    getSearch(query)
                    focusManager.clearFocus()
                }
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .padding(start = 10.dp)
                .height(56.dp)
                .width(56.dp)
                .align(Alignment.Top),
            elevation = 3.dp,
            color = MaterialTheme.colors.primary
        ) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                modifier = Modifier
                    .scale(0.5f),
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}