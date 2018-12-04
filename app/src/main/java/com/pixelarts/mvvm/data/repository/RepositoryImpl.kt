package com.pixelarts.mvvm.data.repository

import android.arch.lifecycle.LiveData
import com.pixelarts.mvvm.data.database.Database
import com.pixelarts.mvvm.data.entities.Country
import java.lang.reflect.Constructor
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val database: Database): Repository{

    override fun getMedals(): LiveData<List<Country>> = database.countryMedalsDao().getCountries()

    override fun insertCountry(country: Country) {
        Thread{
            database.countryMedalsDao().insertCountry(country)
        }.start()
    }

}