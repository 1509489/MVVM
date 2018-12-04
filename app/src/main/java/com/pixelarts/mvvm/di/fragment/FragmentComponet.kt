package com.pixelarts.mvvm.di.fragment

import com.pixelarts.mvvm.factories.AddCountryViewModelFactory
import com.pixelarts.mvvm.ui.AddCountryDialogFragment
import dagger.Component
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponet{

    fun getAddCountryViewModelFactory():AddCountryViewModelFactory

    fun inject(addCoutryDialogFragment: AddCountryDialogFragment)
}