package com.pixelarts.mvvm.di.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import com.pixelarts.mvvm.R
import com.pixelarts.mvvm.databinding.ActivityMainBinding
import com.pixelarts.mvvm.factories.MainViewModelFactory
import com.pixelarts.mvvm.ui.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: AppCompatActivity){
    @Provides
    @ActivityScope
    fun providesMainActivityModel(mainViewModelFactory: MainViewModelFactory) = ViewModelProviders.of(activity, mainViewModelFactory)
        .get(MainViewModel::class.java)

    @Provides
    @ActivityScope
    fun providesMainActivityBinding() = DataBindingUtil.setContentView<ActivityMainBinding>(activity, R.layout.activity_main)


}