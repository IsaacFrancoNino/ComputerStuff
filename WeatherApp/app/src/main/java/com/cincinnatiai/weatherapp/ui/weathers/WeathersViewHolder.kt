package com.cincinnatiai.weatherapp.ui.weathers

import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.weatherapp.databinding.FragmentWeathersScreenBinding
import com.cincinnatiai.weatherapp.databinding.ItemWeatherBinding
import com.cincinnatiai.weatherapp.model.DisplayableWeather
import com.cincinnatiai.weatherapp.model.WeatherModel

class WeathersViewHolder (val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root){

    fun bindModelToView(model: DisplayableWeather){
        binding.title.text = model.name
        binding.temperature.text = "${model.weatherModel.temp_f} °f "
    }


}