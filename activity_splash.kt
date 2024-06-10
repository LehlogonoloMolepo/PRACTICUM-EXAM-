package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash);

        val startButton: Button = findViewById(R.id.btnStart)
        val exitButton: Button = findViewById(R.id.btnExit)

        startButton.setOnClickListener {
            val intent = Intent(this, activity_main::class.java)
            startActivity(intent)
            finish()
        }
        exitButton.setOnClickListener {
            finish()
        }
    }
}


