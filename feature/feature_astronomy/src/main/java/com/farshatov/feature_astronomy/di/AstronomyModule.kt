package com.farshatov.feature_astronomy.di

import com.farshatov.core.location.LocationManager
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
    fun provideAstronomyService(retrofit: Retrofit): AstronomyService = retrofit.create(
        AstronomyService::class.java
    )

    @Provides
    @Singleton
    fun provideAstronomyRepository(api: AstronomyService, locationManager: LocationManager): AstronomyRepository {
        return AstronomyRepositoryImpl(api, locationManager)
    }

    @Provides
    @Singleton
    fun provideGetAstronomyUseCase(repository: AstronomyRepository): GetAstronomyUseCase {
        return GetAstronomyUseCase(repository)
    }
}
