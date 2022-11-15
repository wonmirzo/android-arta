package com.wonmirzo.arta.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "permanent_database")
data class PermanentInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "info_id")
    var id: Int? = null,

    @ColumnInfo(name = "main_info")
    var mainInfo: MainInfo? = null,

    @ColumnInfo(name = "malumot_info")
    var malumot: Malumot? = null,

    @ColumnInfo(name = "ot_ochish_info")
    var otOchish: OtOchish? = null,

    @ColumnInfo(name = "saqlangan_sanasi")
    var date: String? = null
)
