package com.farshatov.feature_current_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(
    @SerializedName("current")
    val current: CurrentDto? = null,
    @SerializedName("location")
    val location: LocationDto? = null
)
