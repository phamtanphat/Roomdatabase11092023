package com.example.roomdatabase11092023.data.database.enity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "id_status")
    val idStatus: Int?,
    val name: String?,
    @ColumnInfo(name = "start_date")
    val startDate: Long?,
    @ColumnInfo(name = "end_date")
    val endDate: Long?
)