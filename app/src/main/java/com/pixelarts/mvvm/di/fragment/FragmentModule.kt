package com.pixelarts.mvvm.di.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.pixelarts.mvvm.factories.AddCountryViewModelFactory
import com.pixelarts.mvvm.ui.AddCountryViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(val fragmet: Fragment){

    @Provides
    @FragmentScope
    fun providesAddCountryViewModel(addCountryViewModelFactory: AddCountryViewModelFactory) =
            ViewModelProviders.of(fragmet, addCountryViewModelFactory)
                .get(AddCountryViewModel::class.java)
}