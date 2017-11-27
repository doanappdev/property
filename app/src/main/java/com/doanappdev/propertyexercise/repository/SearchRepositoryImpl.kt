package com.doanappdev.propertyexercise.repository

import android.util.Log
import com.doanappdev.propertyexercise.Model.SearchResponse
import com.doanappdev.propertyexercise.api.SearchApi
import io.reactivex.Observable


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SearchRepositoryImpl @Inject constructor(val searchApi: SearchApi): SearchRepository {
    override fun getSearchResponse(): Observable<SearchResponse> {
        Log.d("SearchRespositoryImpl", "getSearchResponse called!!")
        return searchApi.getSearchResponse()
    }
}
