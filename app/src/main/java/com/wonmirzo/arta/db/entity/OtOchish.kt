package com.wonmirzo.arta.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ot_ochish_database")
data class OtOchish(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ot_ochish_id")
    var id: Int? = null,

    @ColumnInfo(name = "nishon_number")
    var nishonNumber: String? = null,

    @ColumnInfo(name = "nishon_xarakteri")
    var nishonXarakteri: String? = null,

    var shkala: String? = null,
    var zaryad: String? = null,

    @ColumnInfo(name = "snaryad_turi")
    var snaryadTuri: String? = null,

    @ColumnInfo(name = "portlatgich")
    var portlatgich: String? = null,

    var pr: String? = null,
    var ur: String? = null,
    var ugr: String? = null,

    @ColumnInfo(name = "snaryad_sarfi")
    var snaryadSarfi: String? = null,

    var komanda: String? = null
)