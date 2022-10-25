package com.example.onearmbandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Stats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)


        val homeButton: ImageButton = findViewById(R.id.imageButton2)
        homeButton.setOnClickListener { finish() }


        //change these to consts!!!!!
        val spinMessage = intent.getIntExtra(SPIN_MESSAGE, 0)
        val winMessage = intent.getIntExtra(WIN_MESSAGE, 0)
        val ratioMessage = intent.getDoubleExtra(WIN_LOSS_AVG_MESSAGE, 0.0)

        Log.d("SpinMessage", "$spinMessage")
        Log.d("SpinMessage", "$winMessage")
        Log.d("SpinMessage", "$ratioMessage")


        val spinView = findViewById<TextView>(R.id.spinView).apply {
            text = spinMessage.toString()
        }

        val winView = findViewById<TextView>(R.id.spinView2).apply {
            text = winMessage.toString()

        }

        val winrationView = findViewById<TextView>(R.id.spinView3).apply {
            text = ratioMessage.toString()
        }

    }
}



