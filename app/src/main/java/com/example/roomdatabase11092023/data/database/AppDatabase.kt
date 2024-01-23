package com.example.roomdatabase11092023.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase11092023.data.database.enity.Status
import com.example.roomdatabase11092023.data.database.enity.Task

@Database(entities = [Task::class, Status::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInStance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = "app_database"
                ).build()
            }

            return INSTANCE!!
        }
    }
}