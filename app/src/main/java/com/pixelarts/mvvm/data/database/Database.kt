package com.pixelarts.mvvm.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pixelarts.mvvm.common.DATABASE_VERSION
import com.pixelarts.mvvm.data.dao.CountryMedalsDao
import com.pixelarts.mvvm.data.entities.Country

@Database(entities = [Country::class], version = DATABASE_VERSION)
abstract class Database: RoomDatabase(){

    abstract fun countryMedalsDao():CountryMedalsDao
}