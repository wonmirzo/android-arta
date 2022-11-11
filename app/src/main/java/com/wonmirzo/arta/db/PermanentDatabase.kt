package com.wonmirzo.arta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wonmirzo.arta.db.dao.PermanentDao
import com.wonmirzo.arta.db.entity.PermanentInfo

@Database(entities = [PermanentInfo::class], version = 1)
abstract class PermanentDatabase : RoomDatabase() {

    abstract val permanentDao: PermanentDao

    companion object {
        private var instance: PermanentDatabase? = null

        @Synchronized
        fun getInstance(context: Context): PermanentDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, PermanentDatabase::class.java, "permanent.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance!!
        }
    }
}