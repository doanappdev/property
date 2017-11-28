package com.doanappdev.propertyexercise.model

import com.doanappdev.propertyexercise.PREMIUM_VIEW
import com.doanappdev.propertyexercise.STANDARD_VIEW
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName("ListingResults") val listingResults: ListingResults
)


data class ListingResults(
        @SerializedName("Listings") val listings: List<Listings>
)

data class Listings(
        @SerializedName("AdId") val adId: Int,
        @SerializedName("AgencyColour") val agencyColour: String,
        @SerializedName("AgencyContactPhoto") val agencyContactPhoto: String? = null,
        @SerializedName("AgencyID") val agencyId: Int,
        @SerializedName("AgencyLogoUrl") val agencyLogoUrl: String? = null,
        @SerializedName("IsElite") val isElite: Int
)

//    : ViewType {
//    override fun getViewType(): Int {
//        if (isElite) {
//            return PREMIUM_VIEW
//        }
//        return STANDARD_VIEW
//    }
//}


