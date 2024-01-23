package com.example.roomdatabase11092023.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.roomdatabase11092023.data.database.enity.Task

@Dao
interface AppDAO {
    @Query("SELECT * FROM task")
    fun getListTask(): List<Task>
}