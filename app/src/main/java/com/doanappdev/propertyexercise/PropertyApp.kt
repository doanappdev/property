package com.doanappdev.propertyexercise

import android.app.Application
import com.doanappdev.propertyexercise.di.AppComponent
import com.doanappdev.propertyexercise.di.AppModule
import com.doanappdev.propertyexercise.di.DaggerAppComponent
import com.doanappdev.propertyexercise.di.NetworkModule

class PropertyApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    //@Inject lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()

        // if we want to inject object into this class uncomment this
        //appComponent.inject(this)
    }
}

