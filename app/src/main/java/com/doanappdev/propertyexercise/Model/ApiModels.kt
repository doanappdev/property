package com.doanappdev.propertyexercise.Model

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
        @SerializedName("AgencyContactPhoto") val agencyContactPhoto: String,
        @SerializedName("AgencyID") val agencyId: Int,
        @SerializedName("AgencyLogoUrl") val agencyLogoUrl: String
)
