package com.doanappdev.propertyexercise.ui

import com.doanappdev.propertyexercise.model.Listings
import com.doanappdev.propertyexercise.base.ui.BaseView

interface MainView : BaseView {
    fun setAdapter(listings: List<Listings>)
    fun onSearchError()
}
