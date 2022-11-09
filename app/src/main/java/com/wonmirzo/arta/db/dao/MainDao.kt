package com.wonmirzo.arta.db.dao

import androidx.room.*
import com.wonmirzo.arta.db.entity.MainInfo

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMain(mainInfo: MainInfo): Long

    @Update
    fun updateMain(mainInfo: MainInfo): Int

    @Delete
    fun deleteMain(mainInfo: MainInfo): Int

    @Query("DELETE FROM main_database")
    fun deleteAllMainInfo()

    @Query("SELECT * FROM main_database")
    fun getAllMainInfo(): List<MainInfo>
}