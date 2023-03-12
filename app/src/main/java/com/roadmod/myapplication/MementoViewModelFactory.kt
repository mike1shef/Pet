package com.roadmod.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roadmod.myapplication.repository.BookmarkDao

class MementoViewModelFactory (private val dao: BookmarkDao)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MementoViewModel::class.java))
            return  MementoViewModel (dao) as T
        throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }
    }