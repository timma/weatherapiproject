package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    val forecastday: List<ForecastdayDto>? = null
)
