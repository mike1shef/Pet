package com.roadmod.myapplication.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bookmark::class], version = 1, exportSchema = false)

abstract class AppOutDataBase : RoomDatabase() {
    abstract val bookmarkDao: BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppOutDataBase? = null

        fun getInstance(context: Context): AppOutDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppOutDataBase::class.java,
                        "appOut_DataBase"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}