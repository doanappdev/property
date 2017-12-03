package com.doanappdev.propertyexercise.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName("ListingResults") val listingResults: ListingResults
)


data class ListingResults(
        @SerializedName("Listings") val listings: List<Listing>
)

data class Listing(
        @SerializedName("AgencyColour") val agencyColour: String? = "",
        @SerializedName("AgencyLogoUrl") val agencyLogoUrl: String? = "",
        @SerializedName("Bathrooms") val bathRooms: Int,
        @SerializedName("Bedrooms") val bedRooms: Int,
        @SerializedName("Carspaces") val carSpaces: Int,
        @SerializedName("DisplayPrice") val displayPrice: String,
        @SerializedName("DisplayableAddress") val displayableAddress: String,
        @SerializedName("TruncatedDescription") val truncatedDesc: String? = "",
        @SerializedName("RetinaDisplayThumbUrl") val retinaDisplayThumbUrl: String? = "",
        @SerializedName("SecondRetinaDisplayThumbUrl") val secondThumbUrl: String? = "",
        @SerializedName("ImageUrls") val imageUrls: List<String>,
        @SerializedName("IsElite") val isElite: Int
)


