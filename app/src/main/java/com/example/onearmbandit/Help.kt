package com.example.onearmbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton

private const val TAG = "Help Page"

class Help : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        Log.d(TAG,"Learn the rules")

        val mainButton: ImageButton = findViewById(R.id.imageButton)
        mainButton.setOnClickListener { finish() }

    }


}