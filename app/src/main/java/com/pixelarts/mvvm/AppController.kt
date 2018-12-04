package com.pixelarts.mvvm

import android.app.Application
import com.pixelarts.mvvm.di.application.ApplicationComponent
import com.pixelarts.mvvm.di.application.ApplicationModule
import com.pixelarts.mvvm.di.application.DaggerApplicationComponent

class AppController: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}