package com.farshatov.feature_sports.data.repository

import com.farshatov.common.network.RemoteDataSource
import com.farshatov.common.network.Result
import com.farshatov.core.location.LocationManager
import com.farshatov.feature_sports.data.mapper.mapSportsDto
import com.farshatov.feature_sports.data.remote.SportsService
import com.farshatov.feature_sports.domain.model.SportsModel
import com.farshatov.feature_sports.domain.repository.SportsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SportsRepositoryImpl @Inject constructor(
    private val api: SportsService,
    private val locationManager: LocationManager
) : SportsRepository, RemoteDataSource() {
    override suspend fun fetchSports(): Flow<Result<SportsModel>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            safeApiCall({
                val location = locationManager.getLocationWithLoop()
                val response = api.fetchSports(q = location.toString())
                emit(Result.Success(data = mapSportsDto(response)))
            }, { exception ->
                emit(Result.Error(exception))
            })
        }
    }
}
