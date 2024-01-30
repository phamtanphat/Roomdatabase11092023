package com.example.roomdatabase11092023.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.data.database.AppDatabase
import com.example.roomdatabase11092023.data.database.enity.Status
import com.example.roomdatabase11092023.data.database.enity.StatusEnum
import com.example.roomdatabase11092023.data.database.enity.Task
import com.example.roomdatabase11092023.presentation.dialog.AppDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase.getInStance(this@MainActivity)

//        AppDialog.makeDialogCreateTask(this) {
//            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
//        }
    }
}