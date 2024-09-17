package com.uptc.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textVIewCounter: TextView
    private val prefName: String ="counterPrefs"
    private val counterKey: String ="counter"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textVIewCounter = findViewById(R.id.textViewCounter)

        val sharedPreferences = getSharedPreferences(prefName, Context.MODE_PRIVATE)
        val currentCounter = sharedPreferences.getInt(counterKey,-1)
        val newCounter = currentCounter +1
        textVIewCounter.text = newCounter.toString()
        val editor = sharedPreferences.edit()
        editor.putInt(counterKey,newCounter)
        editor.apply()

    }
}