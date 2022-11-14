package com.wonmirzo.arta.db.dao

import androidx.room.*
import com.wonmirzo.arta.db.entity.PermanentInfo

@Dao
interface PermanentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertInfo(info: PermanentInfo)

    @Update
    fun updateInfo(info: PermanentInfo)

    @Query("SELECT * FROM permanent_database")
    fun getAllInfo(): List<PermanentInfo>

    @Query("DELETE FROM permanent_database")
    fun clearAllInfo()
}