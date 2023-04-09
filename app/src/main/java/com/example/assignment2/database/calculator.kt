package com.example.assignment2.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "Logs_for_calculator_inputs")
data class calculator (
    @PrimaryKey(autoGenerate = true)
    var calcId: Long = 0L,

    @ColumnInfo(name = "result")
    var result: Int = -1
)