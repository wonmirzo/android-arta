package com.wonmirzo.arta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wonmirzo.arta.db.dao.MainDao
import com.wonmirzo.arta.db.dao.MalumotDao
import com.wonmirzo.arta.db.dao.OtOchishDao
import com.wonmirzo.arta.db.entity.MainInfo
import com.wonmirzo.arta.db.entity.Malumot
import com.wonmirzo.arta.db.entity.OtOchish

@Database(entities = [MainInfo::class, Malumot::class, OtOchish::class], version = 3)
abstract class MainDatabase : RoomDatabase() {

    abstract val mainDao: MainDao
    abstract val malumotDao: MalumotDao
    abstract val otOchishDao: OtOchishDao

    companion object {
        private var instance: MainDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MainDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MainDatabase::class.java, "main.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}