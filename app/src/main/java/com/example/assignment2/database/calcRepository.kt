//package com.example.assignment2.database
//
//import androidx.lifecycle.LiveData
//
//class calcRepository(private val calcDatabaseDao: calcDatabaseDao) {
//
//    val readAllData: LiveData<List<calculator>> = calcDatabaseDao.get()
//
//    fun addRes(calculator: calculator){
//        calcDatabaseDao.insert(calculator)
//    }
//
//}