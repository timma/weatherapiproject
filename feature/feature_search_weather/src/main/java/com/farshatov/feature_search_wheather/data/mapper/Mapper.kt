package com.farshatov.feature_search_wheather.data.mapper

import com.farshatov.feature_search_wheather.data.remote.response.SearchWeatherOutputDto
import com.farshatov.feature_search_wheather.data.remote.response.SearchWeatherOutputItemDto
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputItemModel
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel

fun mapSearchWeatherOutputDto(input: SearchWeatherOutputDto): SearchWeatherOutputModel {
    return SearchWeatherOutputModel().apply {
        input.forEach { item ->
            add(mapSearchWeatherOutputItemDto(item))
        }
    }
}

fun mapSearchWeatherOutputItemDto(input: SearchWeatherOutputItemDto): SearchWeatherOutputItemModel {
    return SearchWeatherOutputItemModel(
        name = input.name.orEmpty(),
        region = input.region.orEmpty(),
        country = input.country.orEmpty(),
        lat = input.lat ?: 0.0,
        lon = input.lon ?: 0.0,
        url = input.url.orEmpty(),
        id = input.id ?: 0
    )
}
