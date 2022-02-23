package com.example.kronoxtoapp.kronoxapp.presentation.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleInfo
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SearchViewModel
@Inject
constructor(
    private val repo: ScheduleRepo,
): ViewModel()
{
    val query = mutableStateOf("")
    val listOfAvailablePrograms: MutableState<List<AvailableProgram>> = mutableStateOf(listOf())
    var loading = mutableStateOf(false)

    init{
        try{
            getSearch(query.value)
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    fun getSearch(query: String) {
        viewModelScope.launch {
            loading.value = true
            val result = repo.search(
                query = query
            )

            val scheduleInfoList: MutableList<AvailableProgram> = mutableListOf()

            result.scheduleInfo?.let {
                for(program: Map<String, String> in result.scheduleInfo){
                    scheduleInfoList.add(
                        AvailableProgram(
                            scheduleId = program["scheduleId"],
                            scheduleName = program["scheduleName"]
                        )
                    )
                }
            }

            listOfAvailablePrograms.value = scheduleInfoList
            loading.value = false
        }
    }
    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}