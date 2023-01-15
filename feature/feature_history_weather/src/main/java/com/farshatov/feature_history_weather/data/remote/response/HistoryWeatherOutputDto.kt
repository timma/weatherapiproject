package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class HistoryWeatherOutputDto(
    @SerializedName("forecast")
    val forecast: ForecastDto? = null,
    @SerializedName("location")
    val location: LocationDto? = null
)
