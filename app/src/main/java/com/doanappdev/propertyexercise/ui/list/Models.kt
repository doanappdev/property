package com.doanappdev.propertyexercise.ui.list

import com.doanappdev.propertyexercise.PREMIUM_VIEW
import com.doanappdev.propertyexercise.STANDARD_VIEW
import com.doanappdev.propertyexercise.base.adapter.ViewType

data class StandardItem(
        val adId: Int,
        val agencyColour: String,
        val agencyContactPhoto: String,
        val agencyId: Int,
        val agencyLogoUrl: String,
        val isElite: Int
) : ViewType {
    override fun getViewType(): Int = STANDARD_VIEW
}


//{
//    override fun getViewType(): Int {
//        if (isElite == 0) {
//            return STANDARD_VIEW
//        }
//        return PREMIUM_VIEW
//    }
//}

data class PremiumItem(
        val adId: Int,
        val agencyColour: String,
        val agencyContactPhoto: String?,
        val agencyId: Int,
        val agencyLogoUrl: String?,
        val isElite: Int
) : ViewType {
    override fun getViewType() = PREMIUM_VIEW
}
