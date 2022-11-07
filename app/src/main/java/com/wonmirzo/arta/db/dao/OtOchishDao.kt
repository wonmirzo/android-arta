package com.wonmirzo.arta.db.dao

import androidx.room.*
import com.wonmirzo.arta.db.entity.OtOchish

@Dao
interface OtOchishDao {
    @Insert
    fun insertOtOchish(otOchish: OtOchish)

    @Update
    fun updateOtOchish(otOchish: OtOchish)

    @Delete
    fun deleteOtOchish(otOchish: OtOchish)

    @Query("SELECT * FROM ot_ochish_database")
    fun getAllOtOchish(otOchish: OtOchish)
}