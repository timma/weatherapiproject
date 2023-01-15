package com.farshatov.feature_history_weather.data.repository

import com.farshatov.common.network.RemoteDataSource
import com.farshatov.common.network.Result
import com.farshatov.core.location.LocationManager
import com.farshatov.feature_history_weather.data.mapper.mapHistoryWeatherOutputDto
import com.farshatov.feature_history_weather.data.remote.HistoryWeatherService
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import com.farshatov.feature_history_weather.domain.repository.HistoryWeatherRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryWeatherRepositoryImpl @Inject constructor(
    private val api: HistoryWeatherService,
    private val locationManager: LocationManager
) : HistoryWeatherRepository, RemoteDataSource() {
    override suspend fun fetchHistoryWeather(): Flow<Result<HistoryWeatherOutputModel>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            safeApiCall({
                val location = locationManager.getLocationWithLoop()
                val response = api.fetchHistoryWeather(q = location.toString())
                emit(Result.Success(data = mapHistoryWeatherOutputDto(response)))
            }, { exception ->
                emit(Result.Error(exception))
            })
        }
    }
}
