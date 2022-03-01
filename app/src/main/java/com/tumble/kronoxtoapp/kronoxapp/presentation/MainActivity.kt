package com.tumble.kronoxtoapp.kronoxapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.fragment.NavHostFragment
import com.tumble.kronoxtoapp.R
import com.tumble.kronoxtoapp.kronoxapp.repo.DataStoreRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**** First entry point for the application ****/
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    @Inject
    lateinit var dataRepo: DataStoreRepo
    private val hasFav = mutableStateOf(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.schedule_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.schedule_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        if(hasFavorite()){
            navGraph.setStartDestination(R.id.scheduleListFragment)
        }else{
            navGraph.setStartDestination(R.id.selectionMenu)
        }
        navController.graph = navGraph
    }

    private fun hasFavorite(): Boolean {
        CoroutineScope(Dispatchers.Default).launch {
            hasFav.value = false
        }
        return hasFav.value
    }
}