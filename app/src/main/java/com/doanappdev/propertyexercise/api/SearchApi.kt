package com.doanappdev.propertyexercise.api

import com.doanappdev.propertyexercise.Model.SearchResponse
import io.reactivex.Observable

import retrofit2.http.GET


interface SearchApi {
    @GET("/searchservice.svc/mapsearch?mode=buy&sub=Bondi&pcode s=2026&state=NSW")
    fun getSearchResponse(): Observable<SearchResponse>
}
