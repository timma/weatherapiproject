package com.farshatov.feature_history_weather.domain.model

data class HourModel(
    val chanceOfRain: Int,
    val chanceOfSnow: Int,
    val cloud: Int,
    val condition: ConditionModel,
    val dewpointC: Double,
    val dewpointF: Double,
    val feelslikeC: Double,
    val feelslikeF: Double,
    val gustKph: Double,
    val gustMph: Double,
    val heatindexC: Double,
    val heatindexF: Double,
    val humidity: Int,
    val isDay: Int,
    val precipIn: Double,
    val precipMm: Double,
    val pressureIn: Double,
    val pressureMb: Double,
    val tempC: Double,
    val tempF: Double,
    val time: String,
    val timeEpoch: Int,
    val visKm: Double,
    val visMiles: Double,
    val willItRain: Int,
    val willItSnow: Int,
    val windDegree: Int,
    val windDir: String,
    val windKph: Double,
    val windMph: Double,
    val windchillC: Double,
    val windchillF: Double
)
