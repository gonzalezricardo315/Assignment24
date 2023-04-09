//package com.example.assignment2.database
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class calcViewModel(application: Application): AndroidViewModel(application) {
//
//    private val readAllData: LiveData<List<calculator>>
//    private val repository: calcRepository
//
//    init {
//        val calcDatabaseDao = calcDatabase.getDatabase(application).calcDatabaseDao()
//        repository = calcRepository(calcDatabaseDao)
//        readAllData = repository.readAllData
//    }
//
//    fun addCalc(calculator: calculator){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addRes(calculator)
//        }
//    }
//
//}