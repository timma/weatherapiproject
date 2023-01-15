package com.farshatov.feature_search_wheather.domain.usecase

import com.farshatov.common.network.Result
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel
import com.farshatov.feature_search_wheather.domain.repository.SearchWeatherRepository
import kotlinx.coroutines.flow.Flow

class SearchWeatherUseCase(
    private val repository: SearchWeatherRepository
) {
    suspend operator fun invoke(query: String): Flow<Result<SearchWeatherOutputModel>> {
        return repository.searchWeather(query)
    }
}
