package com.cincinnatiai.weatherapp.di

import com.cincinnatiai.weatherapp.api.WeathersAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DIModule {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weathersAPI: WeathersAPI by lazy {
        retrofit.create(WeathersAPI::class.java)
    }
}