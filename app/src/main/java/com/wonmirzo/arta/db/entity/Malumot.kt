package com.wonmirzo.arta.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "malumot_database")
data class Malumot(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "malumot_id")
    var id: Int? = null,

    @ColumnInfo(name = "asosiy_yn_1")
    var asosiyYn1: String? = null,

    @ColumnInfo(name = "asosiy_yn_2")
    var asosiyYn2: String?,

    @ColumnInfo(name = "zaxira_yn_1")
    var zaxiraYn1: String? = null,

    @ColumnInfo(name = "zaxira_yn_2")
    var zaxiraYn2: String?,

    @ColumnInfo(name = "snaryad_soni")
    var snaryadSoni: String? = null,

    @ColumnInfo(name = "qoldiq")
    var qoldiq: String? = null
)