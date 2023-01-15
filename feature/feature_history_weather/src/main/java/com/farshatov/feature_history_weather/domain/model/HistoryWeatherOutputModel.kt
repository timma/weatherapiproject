package com.farshatov.feature_history_weather.domain.model

data class HistoryWeatherOutputModel(
    val forecast: ForecastModel,
    val location: LocationModel
)
