package com.roadmod.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roadmod.myapplication.repository.BookmarkDao

class MainScreenViewModelFactory (private val dao: BookmarkDao)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainScreenViewModel::class.java)){
            return MainScreenViewModel (dao) as T
        }
        throw IllegalArgumentException ("Unknown ViewModel")
    }
}