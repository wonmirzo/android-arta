package com.wonmirzo.arta.db.dao

import androidx.room.*
import com.wonmirzo.arta.db.entity.Malumot

@Dao
interface MalumotDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMalumot(malumot: Malumot)

    @Update
    fun updateMalumot(malumot: Malumot)

    @Delete
    fun deleteMalumot(malumot: Malumot)

    @Query("DELETE FROM malumot_database")
    fun deleteAllMalumot()

    @Query("SELECT * FROM malumot_database")
    fun getAllMalumot(): List<Malumot>
}