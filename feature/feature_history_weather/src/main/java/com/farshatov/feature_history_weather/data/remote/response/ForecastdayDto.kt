package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ForecastdayDto(
    @SerializedName("astro")
    val astro: AstroDto? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("date_epoch")
    val dateEpoch: Int? = null,
    @SerializedName("day")
    val day: DayDto? = null,
    @SerializedName("hour")
    val hour: List<HourDto>? = null
)
