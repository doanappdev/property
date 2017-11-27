package com.doanappdev.propertyexercise.di

import com.doanappdev.propertyexercise.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    //fun inject(application: DemoApplication)
    fun inject(mainActivity: MainActivity)
    //fun inject(newsActivity: NewsActivity)
    //fun inject(activity: ExampleRecyclerViewActivity)
}
