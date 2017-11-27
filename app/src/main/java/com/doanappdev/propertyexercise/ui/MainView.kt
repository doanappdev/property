package com.doanappdev.propertyexercise.ui

import com.doanappdev.propertyexercise.Model.Listings
import com.doanappdev.propertyexercise.base.ui.BaseMvpView

interface MainView : BaseMvpView {
    fun setAdapter(listings: List<Listings>)
}
