package com.farshatov.feature_sports.domain.usecase

import com.farshatov.common.network.Result
import com.farshatov.feature_sports.domain.model.SportsModel
import com.farshatov.feature_sports.domain.repository.SportsRepository
import kotlinx.coroutines.flow.Flow

class GetSportsUseCase(
    private val repository: SportsRepository
) {

    suspend operator fun invoke(): Flow<Result<SportsModel>> {
        return repository.fetchSports()
    }
}
