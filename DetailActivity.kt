package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter
    private val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//initializing my buttons
        recyclerView = findViewById(R.id.recycler_view)
        val buttonBack: Button = findViewById(R.id.button_back)

        val tempsArray = intent.getStringArrayExtra("tempsArray")
        val weatherList = mutableListOf<WeatherInfo>()

        if (tempsArray != null) {
            for (i in tempsArray.indices) {
                val temp = tempsArray[i].toDouble()
                val maxTemp = temp + 5
                val minTemp = temp - 5
                val condition = if (temp > 25) "Sunny" else "Cloudy"
                weatherList.add(WeatherInfo(daysOfWeek[i], temp, maxTemp, minTemp, condition))
            }
        }//

        val textDetails: TextView = findViewById(R.id.text_details)

        if (tempsArray != null) {
            val details = StringBuilder()
            for (i in tempsArray.indices) {
                details.append("Day ${i + 1}: ${tempsArray[i]}°C\n")
            }
            textDetails.text = details.toString()
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        weatherAdapter = WeatherAdapter(weatherList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = weatherAdapter

        buttonBack.setOnClickListener {
            finish()
        }

    }
}