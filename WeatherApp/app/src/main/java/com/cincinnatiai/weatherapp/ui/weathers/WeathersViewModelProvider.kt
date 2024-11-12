package com.cincinnatiai.weatherapp.ui.weathers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cincinnatiai.weatherapp.di.DIModule

class WeathersViewModelProvider: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeathersViewModel::class.java)){
            return WeathersViewModel(DIModule.weathersAPI) as T
        }
        throw IllegalArgumentException("ModelClass must be assignable from CharactersViewModel")
    }
}