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
            Log.i(TAG, "Listing: adId = ${listing.adId}")
            Log.i(TAG, "Listing: agencyColour = ${listing.agencyColour}")
            Log.i(TAG, "Listing: isElite = ${listing.isElite}")
            Log.i(TAG, "Listing: urlStrings size = ${listing.imageUrls.size}")

            var viewType: ViewType
            if (listing.isElite == 1) {
                viewType = PremiumItem(
                        listing.adId,
                        listing.agencyColour,
                        getValidString(listing.agencyContactPhoto),
                        listing.agencyId,
                        getValidString(listing.agencyLogoUrl),
                        listing.imageUrls,
                        listing.isElite
                )
            } else {
                viewType = StandardItem(
                        listing.adId,
                        listing.agencyColour,
                        getValidString(listing.agencyContactPhoto),
                        listing.agencyId,
                        getValidString(listing.agencyLogoUrl),
                        listing.imageUrls,
                        listing.isElite
                )
            }
            viewTypes.add(viewType)
        }

        return viewTypes
    }

    private fun getValidString(arg: String?) = when(arg.isNullOrEmpty()) {
        true -> ""
        false -> arg
    }
}
