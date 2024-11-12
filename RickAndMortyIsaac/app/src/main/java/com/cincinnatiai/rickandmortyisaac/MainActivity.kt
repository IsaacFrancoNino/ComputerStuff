package com.cincinnatiai.rickandmortyisaac

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cincinnatiai.rickandmortyisaac.databinding.ActivityMainBinding
import com.cincinnatiai.rickandmortyisaac.di.DIModule
import com.cincinnatiai.rickandmortyisaac.ui.characters.CharactersScreenFragment
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

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout, CharactersScreenFragment.newInstance())
                .commit()
        }

    }
}