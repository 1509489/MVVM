package com.pixelarts.mvvm.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pixelarts.mvvm.data.repository.RepositoryImpl
import com.pixelarts.mvvm.ui.AddCountryViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AddCountryViewModelFactory @Inject constructor(val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(AddCountryViewModel::class.java))AddCountryViewModel(repositoryImpl) as T
        else throw IllegalArgumentException("Viewmodel not found")
    }
}