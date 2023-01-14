package com.farshatov.feature_astronomy.data.remote

import com.farshatov.common.BuildConfig
import com.farshatov.feature_astronomy.data.remote.response.AstronomyOutputDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import retrofit2.http.GET
import retrofit2.http.Query

interface AstronomyService {
    @GET("/v1/astronomy.json")
    suspend fun fetchAstronomy(
        @Query("key") key: String = BuildConfig.MAP_KEY,
        @Query("q") q: String,
        @Query("dt") dt: String = LocalDate.now().format(
            DateTimeFormatter.ISO_DATE
        )
    ): AstronomyOutputDto
}
