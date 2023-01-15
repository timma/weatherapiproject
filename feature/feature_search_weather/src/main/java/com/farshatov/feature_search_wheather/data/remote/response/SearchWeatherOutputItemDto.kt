package com.farshatov.feature_search_wheather.data.remote.response

import com.google.gson.annotations.SerializedName

data class SearchWeatherOutputItemDto(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lon")
    val lon: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("url")
    val url: String? = null
)
