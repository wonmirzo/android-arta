package com.wonmirzo.arta.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wonmirzo.arta.db.entity.MainInfo
import com.wonmirzo.arta.db.entity.Malumot
import com.wonmirzo.arta.db.entity.OtOchish

class PermanentInfoTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun mainInfoToString(mainInfo: MainInfo): String {
        return gson.toJson(mainInfo)
    }

    @TypeConverter
    fun stringToMainInfo(mainInfoString: String): MainInfo {
        val objectType = object : TypeToken<MainInfo>() {}.type
        return gson.fromJson(mainInfoString, objectType)
    }

    @TypeConverter
    fun malumotInfoToString(malumotInfo: Malumot): String {
        return gson.toJson(malumotInfo)
    }

    @TypeConverter
    fun stringToMalumotInfo(malumotInfoString: String): Malumot {
        val objectType = object : TypeToken<Malumot>() {}.type
        return gson.fromJson(malumotInfoString, objectType)
    }

    @TypeConverter
    fun otOchishInfoToString(otOchishInfo: OtOchish): String {
        return gson.toJson(otOchishInfo)
    }

    @TypeConverter
    fun stringToOtOchishInfo(otOchishInfoString: String): OtOchish {
        val objectType = object : TypeToken<OtOchish>() {}.type
        return gson.fromJson(otOchishInfoString, objectType)
    }
}