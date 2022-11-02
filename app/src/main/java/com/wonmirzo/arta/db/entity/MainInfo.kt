package com.wonmirzo.arta.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_database")
data class MainInfo(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "main_id")
    var id: Int? = null,

    @ColumnInfo(name = "adn_number")
    var adnNumber: String? = null,

    @ColumnInfo(name = "artileriya_batareyasi")
    var artileriyaBatareyasi: String? = null,

    @ColumnInfo(name = "raschyot")
    var raschyot: String? = null
)
