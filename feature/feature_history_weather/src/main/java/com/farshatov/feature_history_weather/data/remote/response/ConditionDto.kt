package com.farshatov.feature_history_weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("text")
    val text: String? = null
)
