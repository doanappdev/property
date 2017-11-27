package com.doanappdev.propertyexercise.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides @Singleton
    fun provideContext() : Context = application

    @Provides @Singleton
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides @Singleton
    @Named("something")
    fun provideSomething(): String {
        return "something"
    }

    @Provides @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse"
    }

}

