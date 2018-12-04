package com.pixelarts.mvvm.di.application

import com.pixelarts.mvvm.data.repository.RepositoryImpl
import com.pixelarts.mvvm.di.activity.ActivityComponent
import com.pixelarts.mvvm.di.activity.ActivityModule
import dagger.Component

@ApplicationScope

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

    fun getRepository(): RepositoryImpl
}