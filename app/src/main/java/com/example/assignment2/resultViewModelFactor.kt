//package com.example.assignment2
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.assignment2.database.calcDatabaseDao
//
//class resultviewModelFactor(
//    private val dataSource: calcDatabaseDao,
//    private val application: Application
//) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(resultViewModel::class.java)) {
//            return resultViewModel(dataSource, application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}