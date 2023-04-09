//package com.example.assignment2
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Transformations
//import com.example.assignment2.database.calcDatabaseDao
//import com.example.assignment2.database.calculator
//
//class resultViewModel(
//        val database: calcDatabaseDao,
//        application: Application) : AndroidViewModel(application) {
//
//    private val res = database.get()
//
//    val resString = Transformations.map(res) { res ->
//
//    }
//
//    }
//
//    private val result = MutableLiveData<calculator?>()