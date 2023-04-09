package com.example.assignment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [calculator::class], version = 1, exportSchema = false)
abstract class calcDatabase : RoomDatabase() {

    abstract val calcDatabaseDao: calcDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: calcDatabase? = null

        fun getInstance(context: Context): calcDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        calcDatabase::class.java,
                        "calculator_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}