package com.farshatov.feature_sports.data.remote.response

import com.google.gson.annotations.SerializedName

data class SportsDto(
    @SerializedName("cricket")
    val cricket: List<CricketDto?>? = null,
    @SerializedName("football")
    val football: List<FootballDto?>? = null,
    @SerializedName("golf")
    val golf: List<Any?>? = null
)
