package com.farshatov.feature_search_wheather.data.remote

import com.farshatov.common.BuildConfig
import com.farshatov.feature_search_wheather.data.remote.response.SearchWeatherOutputDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchWeatherService {
    @GET("/v1/search.json")
    suspend fun searchWeather(
        @Query("key") key: String = BuildConfig.MAP_KEY,
        @Query("q") q: String
    ): SearchWeatherOutputDto
}
