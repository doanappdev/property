package com.doanappdev.propertyexercise.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName("ListingResults") val listingResults: ListingResults
)


data class ListingResults(
        @SerializedName("Listings") val listings: List<Listing>
)

data class Listing(
        @SerializedName("AdId") val adId: Int,
        @SerializedName("AgencyColour") val agencyColour: String,
        @SerializedName("AgencyContactPhoto") val agencyContactPhoto: String? = null,
        @SerializedName("AgencyID") val agencyId: Int,
        @SerializedName("AgencyLogoUrl") val agencyLogoUrl: String? = null,
        @SerializedName("ImageUrls") val imageUrls: List<String>,
        @SerializedName("IsElite") val isElite: Int
)


