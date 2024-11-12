package com.cincinnatiai.weatherapp.api

import com.cincinnatiai.weatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeathersAPI {
    @GET("current.json")
    suspend fun fetchWeather(@Query ("key") key: String? = "7231db4f2b5a483fb18170129240811" ,@Query ("q") q: String? = null): WeatherResponse
}