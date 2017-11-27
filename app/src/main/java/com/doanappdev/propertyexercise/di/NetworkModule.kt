package com.doanappdev.propertyexercise.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //private val BASE_URL = "https://rest.domain.com.au/searchservice.svc/mapsearch?mode=buy&sub=Bondi&pcode s=2026&state=NSW"
    private val BASE_URL = "https://rest.domain.com.au"

    @Provides @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}
