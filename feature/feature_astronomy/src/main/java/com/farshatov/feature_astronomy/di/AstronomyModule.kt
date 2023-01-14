package com.farshatov.feature_astronomy.di

import com.farshatov.feature_astronomy.data.remote.AstronomyService
import com.farshatov.feature_astronomy.data.repository.AstronomyRepositoryImpl
import com.farshatov.feature_astronomy.domain.repository.AstronomyRepository
import com.farshatov.feature_astronomy.domain.usecase.GetAstronomyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class AstronomyModule {
    @Provides
    @Singleton
    fun provideCurrentWeatherService(retrofit: Retrofit): AstronomyService = retrofit.create(
        AstronomyService::class.java
    )

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(api: AstronomyService): AstronomyRepository {
        return AstronomyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(repository: AstronomyRepository): GetAstronomyUseCase {
        return GetAstronomyUseCase(repository)
    }
}
