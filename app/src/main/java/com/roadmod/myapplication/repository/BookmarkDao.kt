package com.roadmod.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookmarkDao {

    @Insert
    fun insert (bookmark: Bookmark)

    @Insert
    fun insertAll (bookmark: List<Bookmark>)

    @Update
    fun update (bookmark: Bookmark)

    @Delete
    fun delete (bookmark: Bookmark)

    @Query("SELECT * FROM bookmark_table ORDER by bookmarkId DESC")
    fun getAll(): LiveData<List<Bookmark>>

    @Query("SELECT * FROM bookmark_table WHERE done = false ORDER by bookmarkId DESC")
    fun getNotDone(): LiveData<List<Bookmark>>

    @Query("SELECT * FROM bookmark_table WHERE done = true ORDER by bookmarkId DESC")
    fun getDone(): LiveData<List<Bookmark>>

}