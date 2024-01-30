package com.example.roomdatabase11092023.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase11092023.data.database.enity.Status
import com.example.roomdatabase11092023.data.database.enity.Task

@Dao
interface AppDAO {
    @Query("SELECT * FROM task")
    fun getListTask(): List<Task>

    @Query("SELECT * FROM status")
    fun getListStatus(): List<Status>

    @Insert
    fun insertTask(task: Task): Long

    @Insert
    fun addStatus(status: List<Status>): List<Long>
}