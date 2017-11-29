package com.doanappdev.propertyexercise.ui.list

import com.doanappdev.propertyexercise.PREMIUM_VIEW
import com.doanappdev.propertyexercise.STANDARD_VIEW
import com.doanappdev.propertyexercise.base.adapter.ViewType

/**
 * TODO: update these models so we use a base model which these models extend, or pass Listing object into constructor
 * TODO: use Parcelable so object can be saved in bundle (or use ViewModel object provided from google to handle life cycle
 */
data class StandardItem(
        val adId: Int,
        val agencyColour: String,
        val agencyContactPhoto: String?,
        val agencyId: Int,
        val agencyLogoUrl: String?,
        val urlStrings: List<String>,
        val isElite: Int
) : ViewType {
    override fun getViewType(): Int = STANDARD_VIEW
}

data class PremiumItem(
        val adId: Int,
        val agencyColour: String,
        val agencyContactPhoto: String?,
        val agencyId: Int,
        val agencyLogoUrl: String?,
        val urlStrings: List<String>,
        val isElite: Int
) : ViewType {
    override fun getViewType() = PREMIUM_VIEW
}


