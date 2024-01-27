package com.example.roomdatabase11092023.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdatabase11092023.R
import com.example.roomdatabase11092023.data.database.AppDatabase
import com.example.roomdatabase11092023.data.database.enity.Status
import com.example.roomdatabase11092023.data.database.enity.StatusEnum
import com.example.roomdatabase11092023.data.database.enity.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase.getInStance(this@MainActivity)



        CoroutineScope(Dispatchers.IO).launch {
//            val dbDAO = db.appDao()
//            val listTask = dbDAO.getListTask()
//            Log.d("pphat", listTask.toString())

            val dbDAO = db.appDao()
            val listStatus = dbDAO.getListStatus()
            Log.d("pphat", listStatus.toString())

//            val dbDAO = db.appDao()
//            val listRowId = dbDAO.addStatus(listOf(
//                Status(null, StatusEnum.PROGRESS),
//                Status(null, StatusEnum.DONE)
//            ))
//
//            Log.d("pphat", listRowId.toString())
        }
    }
}