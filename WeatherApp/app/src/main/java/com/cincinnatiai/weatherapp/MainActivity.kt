package com.cincinnatiai.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cincinnatiai.weatherapp.databinding.ActivityMainBinding
import com.cincinnatiai.weatherapp.di.DIModule
import com.cincinnatiai.weatherapp.ui.weathers.WeathersScreenFragment
import com.cincinnatiai.weatherapp.ui.weathers.WeathersViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
//        GlobalScope.launch(Dispatchers.IO){
//          var weather =   DIModule.weathersAPI.fetchWeather(q ="USA")
//            println("${weather.current.temp_c.toString()}")
//        }


        if (savedInstanceState  == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout, WeathersScreenFragment.newInstance() )
                .commit()
        }
    }
}

