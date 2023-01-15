package com.farshatov.feature_search_wheather.domain.model

data class SearchWeatherOutputItemModel(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)
