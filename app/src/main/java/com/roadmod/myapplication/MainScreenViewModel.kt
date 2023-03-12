package com.roadmod.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope

import com.roadmod.myapplication.repository.Bookmark
import com.roadmod.myapplication.repository.BookmarkDao
import kotlinx.coroutines.launch

class MainScreenViewModel (val dao: BookmarkDao) : ViewModel() {
    var newBookmarkAddress = ""

    fun addBookmark() {
        viewModelScope.launch {
            val bookmark = Bookmark()
            bookmark.bookmarkAddress = newBookmarkAddress
            dao.insert(bookmark)
        }
    }
}