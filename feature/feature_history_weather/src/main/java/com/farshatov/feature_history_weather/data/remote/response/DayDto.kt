package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("avghumidity")
    val avghumidity: Double? = null,
    @SerializedName("avgtemp_c")
    val avgtempC: Double? = null,
    @SerializedName("avgtemp_f")
    val avgtempF: Double? = null,
    @SerializedName("avgvis_km")
    val avgvisKm: Double? = null,
    @SerializedName("avgvis_miles")
    val avgvisMiles: Double? = null,
    @SerializedName("condition")
    val condition: ConditionDto? = null,
    @SerializedName("maxtemp_c")
    val maxtempC: Double? = null,
    @SerializedName("maxtemp_f")
    val maxtempF: Double? = null,
    @SerializedName("maxwind_kph")
    val maxwindKph: Double? = null,
    @SerializedName("maxwind_mph")
    val maxwindMph: Double? = null,
    @SerializedName("mintemp_c")
    val mintempC: Double? = null,
    @SerializedName("mintemp_f")
    val mintempF: Double? = null,
    @SerializedName("totalprecip_in")
    val totalprecipIn: Double? = null,
    @SerializedName("totalprecip_mm")
    val totalprecipMm: Double? = null,
    @SerializedName("uv")
    val uv: Double? = null
)
