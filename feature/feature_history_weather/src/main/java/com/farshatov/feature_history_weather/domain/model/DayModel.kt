package com.farshatov.feature_history_weather.domain.model

data class DayModel(
    val avghumidity: Double,
    val avgtempC: Double,
    val avgtempF: Double,
    val avgvisKm: Double,
    val avgvisMiles: Double,
    val condition: ConditionModel,
    val maxtempC: Double,
    val maxtempF: Double,
    val maxwindKph: Double,
    val maxwindMph: Double,
    val mintempC: Double,
    val mintempF: Double,
    val totalprecipIn: Double,
    val totalprecipMm: Double,
    val uv: Double
)
