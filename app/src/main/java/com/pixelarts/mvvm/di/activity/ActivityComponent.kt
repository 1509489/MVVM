package com.pixelarts.mvvm.di.activity

import com.pixelarts.mvvm.di.fragment.FragmentComponet
import com.pixelarts.mvvm.di.fragment.FragmentModule
import com.pixelarts.mvvm.factories.MainViewModelFactory
import com.pixelarts.mvvm.ui.MainActivity
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent{

    fun newFragmentComponent(fragmentModule: FragmentModule):FragmentComponet

    fun getMainViewModelFactory():MainViewModelFactory

    fun inject(mainActivity: MainActivity)
}