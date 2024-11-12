package com.cincinnatiai.weatherapp.ui.weathers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cincinnatiai.weatherapp.R
import com.cincinnatiai.weatherapp.api.WeathersAPI
import com.cincinnatiai.weatherapp.model.CitiesList
import com.cincinnatiai.weatherapp.model.DisplayableWeather
import com.cincinnatiai.weatherapp.model.WeatherModel
import com.cincinnatiai.weatherapp.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeathersViewModel(
    private val api: WeathersAPI

): ViewModel() {
    private val _state = MutableLiveData<WeathersUIState>()
    val state: LiveData<WeathersUIState> = _state
    private var currentCity: String = String()
    private var weather: WeatherModel = WeatherModel()
    private var cities = CitiesList().cities
    private var displayableWeathers = mutableListOf<DisplayableWeather>()


    fun fetchWeathers(){
        _state.postValue(WeathersUIState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                for (city in cities){
                    currentCity = city
                    val response: WeatherResponse = api.fetchWeather(q = currentCity)
                    weather = response.current
                    val weatherItem = DisplayableWeather(currentCity,weather)
                    displayableWeathers.add(weatherItem)
                }
                _state.postValue(WeathersUIState.WeatherLoaded(displayableWeathers))


            }catch (e: Throwable){
                _state.postValue(WeathersUIState.Error(R.string.generic_error_message))
            }
        }
    }

}

sealed class WeathersUIState{
    object Loading: WeathersUIState()
    data class WeatherLoaded(val weather: List<DisplayableWeather>): WeathersUIState()
    data class Error (val errorMessage: Int): WeathersUIState()
}