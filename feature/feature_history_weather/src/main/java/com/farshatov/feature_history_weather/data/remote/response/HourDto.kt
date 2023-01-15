package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class HourDto(
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int? = null,
    @SerializedName("chance_of_snow")
    val chanceOfSnow: Int? = null,
    @SerializedName("cloud")
    val cloud: Int? = null,
    @SerializedName("condition")
    val condition: ConditionDto? = null,
    @SerializedName("dewpoint_c")
    val dewpointC: Double? = null,
    @SerializedName("dewpoint_f")
    val dewpointF: Double? = null,
    @SerializedName("feelslike_c")
    val feelslikeC: Double? = null,
    @SerializedName("feelslike_f")
    val feelslikeF: Double? = null,
    @SerializedName("gust_kph")
    val gustKph: Double? = null,
    @SerializedName("gust_mph")
    val gustMph: Double? = null,
    @SerializedName("heatindex_c")
    val heatindexC: Double? = null,
    @SerializedName("heatindex_f")
    val heatindexF: Double? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("is_day")
    val isDay: Int? = null,
    @SerializedName("precip_in")
    val precipIn: Double? = null,
    @SerializedName("precip_mm")
    val precipMm: Double? = null,
    @SerializedName("pressure_in")
    val pressureIn: Double? = null,
    @SerializedName("pressure_mb")
    val pressureMb: Double? = null,
    @SerializedName("temp_c")
    val tempC: Double? = null,
    @SerializedName("temp_f")
    val tempF: Double? = null,
    @SerializedName("time")
    val time: String? = null,
    @SerializedName("time_epoch")
    val timeEpoch: Int? = null,
    @SerializedName("vis_km")
    val visKm: Double? = null,
    @SerializedName("vis_miles")
    val visMiles: Double? = null,
    @SerializedName("will_it_rain")
    val willItRain: Int? = null,
    @SerializedName("will_it_snow")
    val willItSnow: Int? = null,
    @SerializedName("wind_degree")
    val windDegree: Int? = null,
    @SerializedName("wind_dir")
    val windDir: String? = null,
    @SerializedName("wind_kph")
    val windKph: Double? = null,
    @SerializedName("wind_mph")
    val windMph: Double? = null,
    @SerializedName("windchill_c")
    val windchillC: Double? = null,
    @SerializedName("windchill_f")
    val windchillF: Double? = null
)
