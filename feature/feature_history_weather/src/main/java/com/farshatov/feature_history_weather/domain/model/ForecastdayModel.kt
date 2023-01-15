package com.farshatov.feature_history_weather.domain.model

data class ForecastdayModel(
    val astro: AstroModel,
    val date: String,
    val dateEpoch: Int,
    val day: DayModel,
    val hour: List<HourModel>
)
