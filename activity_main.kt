package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class activity_main : AppCompatActivity() {

    private lateinit var inputTemps: EditText
    private lateinit var textAverage: TextView
    private var tempsArray: Array<String>? = null
    private var temps: DoubleArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//declaring my variables
        inputTemps=findViewById(R.id.input_temps)
        textAverage=findViewById(R.id.text_average)
        val buttonCalculate: Button = findViewById(R.id.btnCalculate)
        val buttonDetails: Button = findViewById(R.id.btnDetails)
        val buttonClear: Button = findViewById(R.id.btnClear)
        val buttonExitMain: Button = findViewById(R.id.button_exit_main)
        val buttonBackToSplash: Button = findViewById(R.id.button_back_to_splash)

        buttonCalculate.setOnClickListener{calculateAverage()}//check this
        buttonDetails.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("tempsArray", tempsArray)
            startActivity(intent)
        }
        buttonClear.setOnClickListener { clearData() }
        buttonExitMain.setOnClickListener { finish() }
        buttonBackToSplash.setOnClickListener {
            val intent = Intent(this, activity_main::class.java)
            startActivity(intent)
            finish()
        }

        buttonExitMain.setOnClickListener { finish() }

    }//calculating my average temperature
    private fun calculateAverage() {
        val input = inputTemps.text.toString()
        if (input.isNotEmpty()) {
            tempsArray = input.split(",").toTypedArray()
            temps = DoubleArray(tempsArray!!.size)
            var sum = 0.0
            for (i in tempsArray!!.indices) {
                temps!![i] = tempsArray!![i].trim().toDouble()
                sum += temps!![i]
            }
            val average = sum / tempsArray!!.size
            textAverage.text = "Average Temperature: $average"
        }
    }//reset my page
    private fun clearData() {
        inputTemps.setText("")
        textAverage.text = ""
        tempsArray = null
        temps = null

}
}