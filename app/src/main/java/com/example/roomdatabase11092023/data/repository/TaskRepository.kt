package com.example.roomdatabase11092023.data.repository

import android.content.Context
import com.example.roomdatabase11092023.data.database.AppDAO
import com.example.roomdatabase11092023.data.database.AppDatabase
import com.example.roomdatabase11092023.data.database.enity.Task

class TaskRepository (private var context: Context) {
    private val appDao: AppDAO by lazy {
        AppDatabase.getInStance(context).appDao()
    }

    fun getListTask(): List<Task> {
        return appDao.getListTask()
    }

    fun insertTask(task: Task): Long {
        return appDao.insertTask(task)
    }
}