package com.pixelarts.mvvm.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.pixelarts.mvvm.common.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Country(
    @PrimaryKey(autoGenerate = true)
    val countryId : Int? = null,
    val countryName: String,
    val goldMedals: Int,
    val silverMedals: Int,
    val bronzeMedals: Int,
    val totalMedals: Int = goldMedals + silverMedals + bronzeMedals
)