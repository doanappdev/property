package com.doanappdev.propertyexercise.ui

import android.util.Log
import com.doanappdev.propertyexercise.model.SearchResponse
import com.doanappdev.propertyexercise.base.ui.BasePresenter
import com.doanappdev.propertyexercise.repository.SearchRepository

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


import javax.inject.Inject

class MainPresenter @Inject constructor(val respository: SearchRepository) : BasePresenter<MainView>() {

    private val TAG: String = MainPresenter::class.java.simpleName

    fun getSearchResponse() {
        disposables.add(
            respository.getSearchResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {response -> onSearchSuccess(response)},
                        {onSearchError()}
                )
        )
    }

    private fun onSearchSuccess(response: SearchResponse) {
        val listingsResults = response.listingResults
        val listings = listingsResults.listings
//        for (lr in listings) {
//            Log.i(TAG, "Listing: adId = ${lr.adId}")
//            Log.i(TAG, "Listing: agencyColour = ${lr.agencyColour}")
//        }
        view?.setAdapter(listings)
    }

    private fun onSearchError() {
        //Log.e(TAG, "Search Api Error!")
        view?.onSearchError()
    }
}
