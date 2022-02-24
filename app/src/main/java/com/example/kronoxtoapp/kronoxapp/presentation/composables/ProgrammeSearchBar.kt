package com.example.kronoxtoapp.kronoxapp.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kronoxtoapp.kronoxapp.presentation.ui.search.SearchViewModel
import java.time.format.TextStyle

@OptIn(ExperimentalComposeUiApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun ProgrammeSearchBar(
    viewModel: SearchViewModel
) {
    var query = viewModel.query.value
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
                    viewModel.onQueryChanged(it)
                },
                placeholder = {
                    Text(
                        text = "Search schedules",
                        overflow = TextOverflow.Clip,
                        color = Color(android.graphics.Color.parseColor("#" + "B5B5B5"))
                    )
                },
                shape = RoundedCornerShape(6.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color(android.graphics.Color.parseColor("#" + "5f6368")),
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
                        viewModel.getSearch(query)
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                ),
                trailingIcon = {
                                AnimatedVisibility(
                                    visible = query != "",
                                    enter = fadeIn(),
                                    exit = fadeOut()
                                ) {
                                    IconButton(
                                        onClick = {viewModel.query.value = ""},
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
            )
        }

        Surface(
            onClick = {
                viewModel.getSearch(query)
                focusManager.clearFocus()
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .padding(start = 10.dp)
                .height(56.dp)
                .width(56.dp)
                .align(Alignment.Top),
            elevation = 3.dp
        ) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                modifier = Modifier
                    .scale(0.5f),
                tint = Color(android.graphics.Color.parseColor("#" + "5f6368"))
            )
        }
    }
}