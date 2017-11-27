package com.doanappdev.propertyexercise.di

import com.doanappdev.propertyexercise.api.SearchApi
import com.doanappdev.propertyexercise.repository.SearchRepository
import com.doanappdev.propertyexercise.repository.SearchRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class SearchModule {
    @Provides @Singleton
    fun providesSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

    @Provides @Singleton
    fun providesSearchRepository(api: SearchApi): SearchRepository = SearchRepositoryImpl(api)
}
