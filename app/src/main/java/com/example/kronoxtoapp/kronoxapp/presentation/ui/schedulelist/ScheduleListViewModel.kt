package com.example.kronoxtoapp.kronoxapp.presentation.ui.schedulelist

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.*
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Email.TYPE_MOBILE
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.*
import com.example.kronoxtoapp.kronoxapp.repo.DataStoreRepo
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.domain.model.DayDivider
import com.example.kronoxtoapp.kronoxapp.domain.model.ScheduleDetails
import com.example.kronoxtoapp.kronoxapp.network.util.Resource
import com.example.kronoxtoapp.kronoxapp.presentation.BaseApp
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import kotlin.collections.HashMap

@HiltViewModel
class ScheduleListViewModel
@Inject
constructor(
    private val scheduleRepo: ScheduleRepo,
    private val dataRepo: DataStoreRepo,
    savedStateHandle: SavedStateHandle,
    @Named("BaseApp") app: BaseApp,
    @Named("year") val year: String,
    @Named("month") val month: String,
    @Named("day") val day: String
    ): AndroidViewModel(app)
{
    /**** This is how we transfer the chosen schedules ID to query for, from the previous fragment ****/
    private val itemId = savedStateHandle.getLiveData<Any>("scheduleId")
    val schedules: MutableState<List<Any>> = mutableStateOf(listOf())
    private val scheduleModel: MutableLiveData<Resource<AvailableProgram>> = MutableLiveData()
    private var tempItemId: String? = null
    var onFavoriteSchedule: MutableState<Boolean> = mutableStateOf(false)
    val scheduleList: MutableList<Any> = mutableListOf()
    private val months: List<String> = listOf(
        "january", "february", "march", "april", "may",
        "june", "july", "august", "september", "october", "november", "december")
    var loading = mutableStateOf(false)
    var showScrollToTop = mutableStateOf(false)
    val scheduleActive = mutableStateOf(false)
    val weekActive = mutableStateOf(false)
    val yearActive = mutableStateOf(false)

    /**** Init, is initialised on instantiation of viewmodel ****/
    init{
        try{
            loading.value = true
            decideGet()
        }catch(e: Exception){
            schedules.value = scheduleList
            loading.value = false
            Log.d("Appedebug", "$e")
        }
    }

    private fun decideGet(){
        try{
            if(hasInternet()){
                if(itemId.value != null){
                    /**** Network request ****/
                    CoroutineScope(IO).launch {
                        itemId.value?.let{ it as AvailableProgram
                            if(hasInternet()) newGet(it.scheduleId.toString())
                        }
                    }
                    onFavoriteSchedule.value = false
                }else{
                    CoroutineScope(IO).launch{
                        if(hasInternet()) getSchedule()?.let { newGet(it) }
                    }
                    onFavoriteSchedule.value = true
                }
                scheduleActive.value = true
            }else{
                Toast.makeText(getApplication(),
                    "No internet connection", Toast.LENGTH_LONG).show()
                loading.value = false
            }
        }catch (t: Throwable){
            when(t) {
                is IOException -> scheduleModel.postValue(Resource.Error("Network failure"))
                else -> scheduleModel.postValue(Resource.Error("Conversion error"))
            }
        }
    }

    /**** This function converts a Schedule object into a list of Schedule Details.
        * It bypasses all null values in a month (avoiding the days that aren't available in
        * the JSON object) by using the .let{} function. We also fetch the current month by using
        * the index from Calendar.MONTH and getting its value from a list of month keys. ****/
    private suspend fun newGet(id: String){
        val result = scheduleRepo.get(
            id = id,
            year = year,
            day = day,
            month = month
        )
        CoroutineScope(Default).launch {
            if(result.schedule?.containsKey("error") != true)
            {
                /**** To keep track of when the month has changed from the current to the upcoming ****/
                var firstMonth = true
                val cal = Calendar.getInstance(TimeZone.getDefault())

                /**** Parses through the map of years related to all their 12 months ****/
                result.schedule?.get(cal.get(Calendar.YEAR).toString())?.let{ year ->
                    for(k in 0..6.minus(Calendar.MONTH)){
                        year[months[Calendar.MONTH-1+k]].let {
                            (if (firstMonth) {cal.get(Calendar.DAY_OF_MONTH)..31}
                            else {0..31}).forEach { i: Int ->
                                if(it?.contains(i.toString()) == true){
                                    /**** To find where there is a new day ****/
                                    scheduleList.add(
                                        getDayDividers(it, i)
                                    )
                                    val temp = HashMap(it)
                                    temp[i.toString()] = it[i.toString()]?.drop(1)
                                    for(detail in temp[i.toString()]!!)
                                        scheduleList.add(
                                            getScheduleDetails(detail = detail)
                                        )
                                }
                            }
                        }
                        firstMonth = false
                    }
                }
                /**** Populates the scheduleList which is found in the ScheduleListFragment ****/
                schedules.value = scheduleList
                loading.value = false
            }
            else{
                schedules.value = listOf("Could not find schedule on Kronox")
            }
        }
    }

    private fun getScheduleDetails(detail: Map<String, String>): ScheduleDetails{
        return ScheduleDetails(
            start = detail["start"],
            end = detail["end"],
            course = detail["course"],
            lecturer = detail["lecturer"],
            location = detail["location"],
            title = detail["title"],
            color = detail["color"]
        )
    }

    private fun getDayDividers(it: Map<String, List<Map<String, String>>>?, i: Int): DayDivider{
        return DayDivider(
            dayName = it?.get(i.toString())?.get(0)?.get("dayName"),
            date = it?.get(i.toString())?.get(0)?.get("date")
        )
    }

    private suspend fun getSchedule(): String?{
        return dataRepo.getString("id")
    }

    private fun existsFavorite(): Boolean {
        var saved: String? = null
        viewModelScope.launch {
            saved = getSchedule()
        }
        return !saved.equals("")
    }

    suspend fun toggleFavorite(){
        /**** Safe guard if user clicks several times on the button in one session ****/
        if(existsFavorite() && !onFavoriteSchedule.value){
            tempItemId?.let { saveSchedule(it) }
                ?: itemId.value?.let { it as AvailableProgram
                    saveSchedule(it.scheduleId.toString())
                }
            onFavoriteSchedule.value = true
        }else if(existsFavorite() && onFavoriteSchedule.value){
            tempItemId = getSchedule()
            saveSchedule("")
            onFavoriteSchedule.value = false
        }else if(!existsFavorite() && !onFavoriteSchedule.value){
            itemId.value?.let { it as AvailableProgram
                saveSchedule(it.scheduleId.toString())
            }
            onFavoriteSchedule.value = true
        }
    }
    private suspend fun saveSchedule(value: String){
        dataRepo.putSchedule("id", value)
        Log.d("AppDebug", dataRepo.getString("id").toString())
    }

    fun hasInternet(): Boolean{
        val connectivityManager = getApplication<BaseApp>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when{
                capabilities.hasTransport(TRANSPORT_WIFI) -> true
                capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            connectivityManager.activeNetworkInfo?.run {
                return when(type){
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }
}