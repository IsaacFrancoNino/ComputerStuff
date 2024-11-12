package com.cincinnatiai.rickandmortyisaac.di

import com.cincinnatiai.rickandmortyisaac.api.CharactersApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DIModule {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val charactersApi: CharactersApi by lazy {
        retrofit.create(CharactersApi::class.java)
    }

}