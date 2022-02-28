package com.tumble.kronoxtoapp.kronoxapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.tumble.kronoxtoapp.R
import dagger.hilt.android.AndroidEntryPoint

/**** First entry point for the application ****/
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.schedule_activity)
    }
}