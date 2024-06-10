package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(private val weatherList: List<WeatherInfo>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayText: TextView = itemView.findViewById(R.id.text_day)
        val tempText: TextView = itemView.findViewById(R.id.text_temp)
        val maxTempText: TextView = itemView.findViewById(R.id.text_max_temp)
        val minTempText: TextView = itemView.findViewById(R.id.text_min_temp)
        val conditionText: TextView = itemView.findViewById(R.id.text_weather_condition)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_weather_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.dayText.text = weather.day
        holder.tempText.text = "Temperature: ${weather.temp}°C"
        holder.maxTempText.text = "Max Temp: ${weather.maxTemp}°C"
        holder.minTempText.text = "Min Temp: ${weather.minTemp}°C"
        holder.conditionText.text = "Condition: ${weather.condition}"
    }

    override fun getItemCount() = weatherList.size
}

