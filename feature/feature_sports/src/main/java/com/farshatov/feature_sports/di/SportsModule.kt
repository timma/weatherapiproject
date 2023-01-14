package com.farshatov.feature_sports.di

import com.farshatov.feature_sports.data.remote.SportsService
import com.farshatov.feature_sports.data.repository.SportsRepositoryImpl
import com.farshatov.feature_sports.domain.repository.SportsRepository
import com.farshatov.feature_sports.domain.usecase.GetSportsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SportsModule {
    @Provides
    @Singleton
    fun provideCurrentWeatherService(retrofit: Retrofit): SportsService = retrofit.create(
        SportsService::class.java
    )

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(api: SportsService): SportsRepository {
        return SportsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(repository: SportsRepository): GetSportsUseCase {
        return GetSportsUseCase(repository)
    }
}
