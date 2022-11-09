package com.wonmirzo.arta.db.dao

import androidx.room.*
import com.wonmirzo.arta.db.entity.OtOchish

@Dao
interface OtOchishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOtOchish(otOchish: OtOchish)

    @Update
    fun updateOtOchish(otOchish: OtOchish)

    @Delete
    fun deleteOtOchish(otOchish: OtOchish)

    @Query("DELETE FROM ot_ochish_database")
    fun deleteAllOtOchish()

    @Query("SELECT * FROM ot_ochish_database")
    fun getAllOtOchish(): List<OtOchish>
}