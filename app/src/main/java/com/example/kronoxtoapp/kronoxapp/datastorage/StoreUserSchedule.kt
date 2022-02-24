package com.example.kronoxtoapp.kronoxapp.datastorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**** This class is primarily used for storing local config of the users desired schedule ****/
class StoreUserSchedule(
    private val context: Context
) {
    companion object{
        private val Context.dataStoree:
                DataStore<Preferences> by preferencesDataStore("scheduleId")
        val USER_SCHEDULE_KEY = stringPreferencesKey("scheduleId")
    }
    val getId: Flow<String?> = context.dataStoree.data.map {
        it[USER_SCHEDULE_KEY] ?: "temp"
    }

    suspend fun saveSchedule(scheduleId: String){
        context.dataStoree.edit {
            it[USER_SCHEDULE_KEY] = scheduleId
        }
    }

}