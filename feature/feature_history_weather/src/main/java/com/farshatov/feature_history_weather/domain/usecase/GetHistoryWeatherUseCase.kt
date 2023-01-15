package com.farshatov.feature_history_weather.domain.usecase

import com.farshatov.common.network.Result
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import com.farshatov.feature_history_weather.domain.repository.HistoryWeatherRepository
import kotlinx.coroutines.flow.Flow

class GetHistoryWeatherUseCase(
    private val repository: HistoryWeatherRepository
) {

    suspend operator fun invoke(): Flow<Result<HistoryWeatherOutputModel>> {
        return repository.fetchHistoryWeather()
    }
}
