package com.farshatov.feature_astronomy.domain.model

data class LocationModel(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
)
