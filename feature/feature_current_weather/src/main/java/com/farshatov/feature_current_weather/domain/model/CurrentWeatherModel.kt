package com.farshatov.feature_current_weather.domain.model

data class CurrentWeatherModel(
    val current: CurrentModel,
    val location: LocationModel
)
