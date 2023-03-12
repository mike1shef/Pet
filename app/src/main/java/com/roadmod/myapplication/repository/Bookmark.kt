package com.roadmod.myapplication.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark_table")
data class Bookmark(

    @PrimaryKey(autoGenerate = true)
    var bookmarkId: Long = 0L,

    @ColumnInfo(name = "url")
    var bookmarkAddress: String = "",

    @ColumnInfo(name = "done")
    var bookmarkDone: Boolean = false
)
