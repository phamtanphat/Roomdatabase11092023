package com.example.roomdatabase11092023.data.database.enity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(tableName = "status")
data class Status (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @TypeConverters(StatusConverter::class)
    val name: StatusEnum?
)

enum class StatusEnum {
    START,
    PROGRESS,
    DONE;

    fun getIndex(): Int = ordinal + 1

    fun getNameByIndex(index: Int): String {
        return when (index) {
            START.getIndex() -> START.name
            PROGRESS.getIndex() -> PROGRESS.name
            else -> DONE.name
        }
    }
}

class StatusConverter {

    @TypeConverter
    fun toStatus(value: Int) = enumValues<StatusEnum>()[value]

    @TypeConverter
    fun fromStatus(value: StatusEnum) = value.ordinal
}