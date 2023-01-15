package com.farshatov.feature_current_weather.data.remote

import com.farshatov.common.BuildConfig
import com.farshatov.feature_current_weather.data.remote.response.CurrentWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherService {

    @GET("/v1/current.json")
    suspend fun fetchCurrentWeather(
        @Query("key") key: String = BuildConfig.MAP_KEY,
        @Query("q") q: String,
        @Query("aqi") aqi: String = AQI.YES.title
    ): CurrentWeatherDto
}
