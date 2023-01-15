package com.farshatov.feature_astronomy.data.repository

import com.farshatov.common.network.RemoteDataSource
import com.farshatov.common.network.Result
import com.farshatov.core.location.LocationManager
import com.farshatov.feature_astronomy.data.mapper.mapAstronomyOutputDto
import com.farshatov.feature_astronomy.data.remote.AstronomyService
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import com.farshatov.feature_astronomy.domain.repository.AstronomyRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AstronomyRepositoryImpl @Inject constructor(
    private val api: AstronomyService,
    private val locationManager: LocationManager
) : AstronomyRepository, RemoteDataSource() {
    override suspend fun fetchAstronomy(): Flow<Result<AstronomyOutputModel>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            safeApiCall({
                val location = locationManager.getLocationWithLoop()
                val response = api.fetchAstronomy(q = location.toString())
                emit(Result.Success(data = mapAstronomyOutputDto(response)))
            }, { exception ->
                emit(Result.Error(exception))
            })
        }
    }
}
