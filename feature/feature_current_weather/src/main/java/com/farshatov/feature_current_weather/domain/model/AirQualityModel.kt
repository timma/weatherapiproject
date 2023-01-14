package com.farshatov.feature_current_weather.domain.model

data class AirQualityModel(
    val co: Double,
    val gbDefraIndex: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm25: Double,
    val so2: Double,
    val usEpaIndex: Int
)
