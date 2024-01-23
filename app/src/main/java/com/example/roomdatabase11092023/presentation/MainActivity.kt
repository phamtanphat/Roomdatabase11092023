package com.example.roomdatabase11092023.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.data.database.enity.Task

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = Task(
            id = 1,
            idStatus = null,
            name = null,
            startDate = null,
            endDate = null
        )

        Log.d("pphat", task.toString())
    }
}