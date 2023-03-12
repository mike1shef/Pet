package com.roadmod.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roadmod.myapplication.repository.BookmarkDao

class LibraryViewModelFactory (private val dao: BookmarkDao)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LibraryViewModel::class.java))
            return  LibraryViewModel (dao) as T
        throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }
    }