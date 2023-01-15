package com.farshatov.feature_history_weather.data.remote

import com.farshatov.common.BuildConfig
import com.farshatov.feature_history_weather.data.remote.response.HistoryWeatherOutputDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import retrofit2.http.GET
import retrofit2.http.Query

interface HistoryWeatherService {

    @GET("/v1/history.json")
    suspend fun fetchHistoryWeather(
        @Query("key") key: String = BuildConfig.MAP_KEY,
        @Query("q") q: String,
        @Query("dt") dt: String = LocalDate.now().minusWeeks(1).format(
            DateTimeFormatter.ISO_DATE
        )
    ): HistoryWeatherOutputDto
}
