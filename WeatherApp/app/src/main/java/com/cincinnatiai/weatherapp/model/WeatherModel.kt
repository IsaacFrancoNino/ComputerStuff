package com.cincinnatiai.weatherapp.model

data class WeatherModel(
    val temp_c: Double = 0.0,
    val temp_f: Double = 0.0
)

data class DisplayableWeather(
    val name: String,
    val weatherModel: WeatherModel
)


data class CitiesList(
    val cities: List<String> = listOf("LA","London","Mexico City","New Delhi")
)