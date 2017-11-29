package com.doanappdev.propertyexercise.ui

import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.base.ui.BaseView

interface MainView : BaseView {
    fun setAdapter(viewTypes: List<ViewType>)
    fun onSearchError()
}
