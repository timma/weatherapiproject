package com.farshatov.feature_sports.data.remote

import com.farshatov.common.BuildConfig
import com.farshatov.feature_sports.data.remote.response.SportsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsService {

    @GET("/v1/sports.json")
    suspend fun fetchSports(
        @Query("key") key: String = BuildConfig.MAP_KEY,
        @Query("q") q: String
    ): SportsDto
}
