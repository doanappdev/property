package com.doanappdev.propertyexercise.ui.list

import android.arch.lifecycle.ViewModel
import com.doanappdev.propertyexercise.PREMIUM_VIEW
import com.doanappdev.propertyexercise.STANDARD_VIEW
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.model.Listing

class StandardItem(listing: Listing) : BaseListingItem(listing), ViewType {
    override fun getViewType() = STANDARD_VIEW
}

class PremiumItem(listing: Listing) : BaseListingItem(listing), ViewType {
    override fun getViewType() = PREMIUM_VIEW
}

open class BaseListingItem(listing: Listing) {

    var agencyColour: String? = ""
    var agencyLogoUrl: String? = ""
    var bathRooms: Int
    var bedRooms: Int
    var carSpaces: Int
    var displayPrice: String
    var displayableAddress: String
    var truncatedDesc: String? = ""
    var retinaDisplayThumbUrl: String? = ""
    var secondThumbUrl: String? = ""
    var isElite: Int

    init {
        agencyColour = listing.agencyColour
        agencyLogoUrl = listing.agencyLogoUrl
        bathRooms = listing.bathRooms
        bedRooms = listing.bedRooms
        carSpaces = listing.carSpaces
        displayPrice = listing.displayPrice
        displayableAddress = listing.displayableAddress
        truncatedDesc = listing.truncatedDesc
        retinaDisplayThumbUrl = listing.retinaDisplayThumbUrl
        secondThumbUrl = listing.secondThumbUrl
        isElite = listing.isElite
    }

    fun getRowTwoString() = StringBuilder()
            .append(bedRooms).append(" bed,")
            .append(bathRooms).append(" bath,")
            .append(carSpaces).append(" car")
            .toString()
}

class PropertiesViewModel : ViewModel() {
    var viewTypes = emptyList<ViewType>()
}


