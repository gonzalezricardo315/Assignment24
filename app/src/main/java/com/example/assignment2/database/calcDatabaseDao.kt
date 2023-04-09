package com.example.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface calcDatabaseDao {


    //need insert and get all
    @Insert
    fun insert(res: calculator)

    @Query("SELECT * from Logs_for_calculator_inputs WHERE calcId = :key")
    fun get(key: Long): calculator?

    @Query("DELETE FROM Logs_for_calculator_inputs")
    fun clear()

}