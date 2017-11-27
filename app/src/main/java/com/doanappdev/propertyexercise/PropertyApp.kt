package com.doanappdev.propertyexercise

import android.app.Application
import com.doanappdev.propertyexercise.di.*

class PropertyApp : Application() {

    lateinit var appComponent: AppComponent
    //@Inject lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        setupComponent()

    }

    private fun setupComponent() {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .searchModule(SearchModule())
                .build()


        // if we want to inject object into this class uncomment this
        //appComponent.inject(this)
    }
}

