package com.doanappdev.propertyexercise.repository

import com.doanappdev.propertyexercise.Model.SearchResponse
import io.reactivex.Observable


interface SearchRepository {
    fun getSearchResponse(): Observable<SearchResponse>
}