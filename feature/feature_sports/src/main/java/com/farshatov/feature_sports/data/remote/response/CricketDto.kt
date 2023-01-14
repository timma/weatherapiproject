package com.farshatov.feature_sports.data.remote.response

import com.google.gson.annotations.SerializedName

data class CricketDto(
    @SerializedName("country")
    val country: String?,
    @SerializedName("match")
    val match: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("stadium")
    val stadium: String?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("tournament")
    val tournament: String?
)
