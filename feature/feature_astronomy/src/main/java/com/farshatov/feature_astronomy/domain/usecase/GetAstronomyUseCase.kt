package com.farshatov.feature_astronomy.domain.usecase

import com.farshatov.common.network.Result
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import com.farshatov.feature_astronomy.domain.repository.AstronomyRepository
import kotlinx.coroutines.flow.Flow

class GetAstronomyUseCase(
    private val repository: AstronomyRepository
) {
    suspend operator fun invoke(): Flow<Result<AstronomyOutputModel>> {
        return repository.fetchAstronomy()
    }
}
