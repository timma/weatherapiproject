package com.farshatov.feature_sports.domain.repository

import com.farshatov.common.network.Result
import com.farshatov.feature_sports.domain.model.SportsModel
import kotlinx.coroutines.flow.Flow

interface SportsRepository {
    suspend fun fetchSports(): Flow<Result<SportsModel>>
}
