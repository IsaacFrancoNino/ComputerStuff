package com.cincinnatiai.weatherapp.ui.weathers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.weatherapp.databinding.ItemWeatherBinding
import com.cincinnatiai.weatherapp.model.DisplayableWeather
import com.cincinnatiai.weatherapp.model.WeatherModel

class WeathersAdapter: RecyclerView.Adapter<WeathersViewHolder>() {
    private val items = mutableListOf<DisplayableWeather>()
    fun  setItems(models: List<DisplayableWeather>){
        items.clear()
        items.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeathersViewHolder {
        val binding: ItemWeatherBinding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeathersViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: WeathersViewHolder, position: Int) {
        holder.bindModelToView(items[position])
    }

}