package com.tumble.kronoxtoapp.kronoxapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.navigation.fragment.NavHostFragment
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.repo.DataStoreRepo
import com.tumble.kronoxtoapp.kronoxapp.repo.ScheduleRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

/**** First entry point for the application ****/
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
@Inject @Named("BaseApp") lateinit var baseApp: BaseApp
@Inject lateinit var repo: ScheduleRepo
@Inject lateinit var dataRepo: DataStoreRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.main_activity)
        val navHostFragment = (supportFragmentManager?.findFragmentById(R.id.schedule_nav_host_fragment) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        graph.setStartDestination(R.layout.schedule_list_fragment)

        navHostFragment.navController.graph = graph

    }


    private fun getFavorite(): Boolean{
        var isFavorite = true
        CoroutineScope(Default).launch {
            if (dataRepo.getString("id").equals("") || dataRepo.getString("id").equals(null)) {
                isFavorite = false
            }
        }
        return isFavorite
    }
}