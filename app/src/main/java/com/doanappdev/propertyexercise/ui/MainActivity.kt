package com.doanappdev.propertyexercise.ui

import android.os.Bundle
import android.util.Log
import com.doanappdev.propertyexercise.Model.Listings
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.ui.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    private val TAG: String = MainActivity::class.java.simpleName

    @Inject lateinit var presenter: MainPresenter


    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent?.inject(this)
        presenter.bind(this)

        presenter.getSearchResponse()
    }

    override fun setAdapter(listings: List<Listings>) {
        for (lr in listings) {
            Log.i(TAG, "Listing: adId = ${lr.adId}")
            Log.i(TAG, "Listing: agencyColour = ${lr.agencyColour}")
        }
    }
}
