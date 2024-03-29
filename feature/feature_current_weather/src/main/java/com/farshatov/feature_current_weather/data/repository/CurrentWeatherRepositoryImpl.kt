package com.farshatov.feature_current_weather.data.repository

import com.farshatov.common.network.RemoteDataSource
import com.farshatov.common.network.Result
import com.farshatov.core.location.LocationManager
import com.farshatov.feature_current_weather.data.mapper.mapCurrentWeatherDto
import com.farshatov.feature_current_weather.data.remote.CurrentWeatherService
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val api: CurrentWeatherService,
    private val locationManager: LocationManager
) : CurrentWeatherRepository, RemoteDataSource() {
    override suspend fun fetchWeather(): Flow<Result<CurrentWeatherModel>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            safeApiCall({
                val location = locationManager.getLocationWithLoop()
                val response = api.fetchCurrentWeather(q = location.toString())
                emit(Result.Success(data = mapCurrentWeatherDto(response)))
            }, { exception ->
                emit(Result.Error(exception))
            })
        }
    }
}
