package com.doanappdev.propertyexercise.repository

import com.doanappdev.propertyexercise.model.SearchResponse
import io.reactivex.Observable


interface SearchRepository {
    fun getSearchResponse(): Observable<SearchResponse>
}