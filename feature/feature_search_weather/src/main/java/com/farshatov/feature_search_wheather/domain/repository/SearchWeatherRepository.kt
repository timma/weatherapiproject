package com.farshatov.feature_search_wheather.domain.repository

import com.farshatov.common.network.Result
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel
import kotlinx.coroutines.flow.Flow

interface SearchWeatherRepository {
    suspend fun searchWeather(query: String): Flow<Result<SearchWeatherOutputModel>>
}
