package com.pixelarts.mvvm.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pixelarts.mvvm.data.repository.RepositoryImpl
import com.pixelarts.mvvm.ui.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) MainViewModel(repositoryImpl) as T
        else throw IllegalArgumentException("ViewModel not found")
    }
}