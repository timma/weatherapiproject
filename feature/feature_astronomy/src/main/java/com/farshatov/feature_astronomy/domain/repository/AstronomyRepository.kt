package com.farshatov.feature_astronomy.domain.repository

import com.farshatov.common.network.Result
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import kotlinx.coroutines.flow.Flow

interface AstronomyRepository {
    suspend fun fetchAstronomy(): Flow<Result<AstronomyOutputModel>>
}
