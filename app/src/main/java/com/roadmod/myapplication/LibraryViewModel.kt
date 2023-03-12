package com.roadmod.myapplication

import androidx.lifecycle.ViewModel
import com.roadmod.myapplication.repository.BookmarkDao

class LibraryViewModel (dao: BookmarkDao) : ViewModel() {
    val bookmarks = dao.getAll()


}