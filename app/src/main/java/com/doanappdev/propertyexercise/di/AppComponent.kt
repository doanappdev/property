package com.doanappdev.propertyexercise.di

import com.doanappdev.propertyexercise.ui.MainActivity
import com.doanappdev.propertyexercise.PropertyApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        SearchModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(propertyApp: PropertyApp): Builder
        fun appModule(appModule: AppModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun searchModule(searchModule: SearchModule): Builder
        fun build(): AppComponent
    }
}
