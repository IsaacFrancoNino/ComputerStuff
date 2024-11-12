package com.hmmg.rickandmorty.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                RickandMortyApp()

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RickandMortyApp(){
    Scaffold (
        content =  {
            RickandMortyContent()
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)

@Composable
fun GreetingPreview() {

        Greeting("Android")
}