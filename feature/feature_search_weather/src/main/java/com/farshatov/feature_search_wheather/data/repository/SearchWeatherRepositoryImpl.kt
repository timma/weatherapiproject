package com.farshatov.feature_search_wheather.data.repository

import com.farshatov.common.network.RemoteDataSource
import com.farshatov.common.network.Result
import com.farshatov.feature_search_wheather.data.mapper.mapSearchWeatherOutputDto
import com.farshatov.feature_search_wheather.data.remote.SearchWeatherService
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel
import com.farshatov.feature_search_wheather.domain.repository.SearchWeatherRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchWeatherRepositoryImpl @Inject constructor(
    private val api: SearchWeatherService
) : SearchWeatherRepository, RemoteDataSource() {
    override suspend fun searchWeather(query: String): Flow<Result<SearchWeatherOutputModel>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            safeApiCall({
                val response = api.searchWeather(q = query)
                emit(Result.Success(data = mapSearchWeatherOutputDto(response)))
            }, { exception ->
                emit(Result.Error(exception))
            })
        }
    }
}
