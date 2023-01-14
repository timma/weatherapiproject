package com.farshatov.feature_current_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("text")
    val text: String
)
