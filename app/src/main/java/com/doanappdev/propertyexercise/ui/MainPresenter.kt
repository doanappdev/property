package com.doanappdev.propertyexercise.ui

import android.util.Log
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.model.SearchResponse
import com.doanappdev.propertyexercise.base.ui.BasePresenter
import com.doanappdev.propertyexercise.model.Listing
import com.doanappdev.propertyexercise.repository.SearchRepository
import com.doanappdev.propertyexercise.ui.list.PremiumItem
import com.doanappdev.propertyexercise.ui.list.StandardItem

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
        view?.setAdapter(createListingViewTypes(listings))
    }

    private fun onSearchError() {
        view?.onSearchError()
    }

    private fun createListingViewTypes(listings: List<Listing>): List<ViewType> {
        val viewTypes = ArrayList<ViewType>()
        for (listing in listings) {
            when(listing.isElite == 1) {
                true -> viewTypes.add(PremiumItem(listing))
                false -> viewTypes.add(StandardItem(listing))
            }
        }

        return viewTypes
    }
}
