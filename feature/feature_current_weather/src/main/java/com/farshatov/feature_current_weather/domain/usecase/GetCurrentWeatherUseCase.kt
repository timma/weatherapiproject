package com.farshatov.feature_current_weather.domain.usecase

import com.farshatov.common.network.Result
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.domain.repository.CurrentWeatherRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentWeatherUseCase(
    private val repository: CurrentWeatherRepository
) {

    suspend operator fun invoke(): Flow<Result<CurrentWeatherModel>> {
        return repository.fetchWeather()
    }
}
