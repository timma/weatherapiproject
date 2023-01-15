package com.farshatov.feature_history_weather.domain.repository

import com.farshatov.common.network.Result
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import kotlinx.coroutines.flow.Flow

interface HistoryWeatherRepository {
    suspend fun fetchHistoryWeather(): Flow<Result<HistoryWeatherOutputModel>>
}
