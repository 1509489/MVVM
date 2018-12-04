package com.pixelarts.mvvm.ui

import android.arch.lifecycle.ViewModel
import com.pixelarts.mvvm.data.entities.Country
import com.pixelarts.mvvm.data.repository.RepositoryImpl

class AddCountryViewModel(val repositoryImpl: RepositoryImpl):ViewModel(){
    fun insertCountry(countryName: String, goldMedals: String, silverMedals: String, bronzeMedals: String){
        val coountry = Country(
            countryName = countryName,
            goldMedals = goldMedals.toInt(),
            silverMedals = silverMedals.toInt(),
            bronzeMedals = bronzeMedals.toInt()
        )
        repositoryImpl.insertCountry(coountry)
    }
}