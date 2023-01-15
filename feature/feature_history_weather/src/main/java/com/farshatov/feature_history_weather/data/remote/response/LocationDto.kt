package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("localtime")
    val localtime: String? = null,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int? = null,
    @SerializedName("lon")
    val lon: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("tz_id")
    val tzId: String? = null
)
