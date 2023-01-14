package com.farshatov.feature_current_weather.domain.repository

import com.farshatov.common.network.Result
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepository {
    suspend fun fetchWeather(): Flow<Result<CurrentWeatherModel>>
}
