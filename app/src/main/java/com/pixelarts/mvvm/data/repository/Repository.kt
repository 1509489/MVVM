package com.pixelarts.mvvm.data.repository

import android.arch.lifecycle.LiveData
import com.pixelarts.mvvm.data.entities.Country

interface Repository{
    fun getMedals(): LiveData<List<Country>>
    fun insertCountry(country: Country)
}