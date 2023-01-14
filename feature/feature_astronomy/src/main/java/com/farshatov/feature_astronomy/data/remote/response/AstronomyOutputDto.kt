package com.farshatov.feature_astronomy.data.remote.response

import com.google.gson.annotations.SerializedName

data class AstronomyOutputDto(
    @SerializedName("astronomy")
    val astronomy: AstronomyDto? = null,
    @SerializedName("location")
    val location: LocationDto? = null
)
