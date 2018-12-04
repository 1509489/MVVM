package com.pixelarts.mvvm.di.application

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pixelarts.mvvm.data.database.Database
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application){
    @Provides
    @ApplicationScope
    fun providesContext(): Context = application

    @Provides
    @ApplicationScope
    fun providesDatabase(): Database = Room.databaseBuilder(application.applicationContext,
        Database::class.java, "database-Database").build()
}