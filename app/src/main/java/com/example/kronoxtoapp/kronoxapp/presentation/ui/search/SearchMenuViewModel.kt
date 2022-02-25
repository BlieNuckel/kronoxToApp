package com.example.kronoxtoapp.kronoxapp.presentation.ui.search

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.*
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Email.TYPE_MOBILE
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kronoxtoapp.kronoxapp.repo.DataStoreRepo
import com.example.kronoxtoapp.kronoxapp.domain.model.AvailableProgram
import com.example.kronoxtoapp.kronoxapp.network.util.Resource
import com.example.kronoxtoapp.kronoxapp.presentation.BaseApp
import com.example.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SearchMenuViewModel
@Inject
constructor(
    @Named("BaseApp") val app: BaseApp,
    private val repo: ScheduleRepo,
    private val dataRepo: DataStoreRepo
): AndroidViewModel(app)
{
    private val query = mutableStateOf("")
    private val scheduleModel: MutableLiveData<Resource<AvailableProgram>> = MutableLiveData()
    val listOfAvailablePrograms: MutableState<List<AvailableProgram>> = mutableStateOf(listOf())
    var loading = mutableStateOf(false)
    var liftMenu = mutableStateOf(false)

    suspend fun getSearch(query: String) {
        try{
            if(hasInternet()){
                if (query == "") return
                CoroutineScope(Default).launch {
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
                    if (scheduleInfoList.size != 0) {
                        liftMenu.value = true
                    }
                    loading.value = false
                }
            }
        }catch (t: Throwable){
            when(t) {
                is IOException -> scheduleModel.postValue(Resource.Error("Network failure"))
                else -> scheduleModel.postValue(Resource.Error("Conversion error"))
            }
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }
    fun getSchedule(): String? = runBlocking {
        dataRepo.getString("id")
    }

    fun getQueryValue(): String {
        return query.value
    }

    fun setQueryValue(it: String) {
        query.value = it
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

    fun hasFavorite(): Boolean{
        return !getSchedule().equals("")
    }
}