package com.wonmirzo.arta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wonmirzo.arta.db.dao.MainDao
import com.wonmirzo.arta.db.entity.MainInfo

@Database(entities = [MainInfo::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract val mainDao: MainDao

    companion object {
        private var instanse: MainDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MainDatabase {
            if (instanse == null) {
                instanse = Room.databaseBuilder(context, MainDatabase::class.java, "main.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instanse!!
        }
    }
}