package com.farshatov.feature_current_weather.di

import com.farshatov.core.location.LocationManager
import com.farshatov.feature_current_weather.data.remote.CurrentWeatherService
import com.farshatov.feature_current_weather.data.repository.CurrentWeatherRepositoryImpl
import com.farshatov.feature_current_weather.domain.repository.CurrentWeatherRepository
import com.farshatov.feature_current_weather.domain.usecase.GetCurrentWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class CurrentWeatherModule {
    @Provides
    @Singleton
    fun provideCurrentWeatherService(retrofit: Retrofit): CurrentWeatherService = retrofit.create(
        CurrentWeatherService::class.java
    )

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(
        api: CurrentWeatherService,
        locationManager: LocationManager
    ): CurrentWeatherRepository {
        return CurrentWeatherRepositoryImpl(api, locationManager)
    }

    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(repository: CurrentWeatherRepository): GetCurrentWeatherUseCase {
        return GetCurrentWeatherUseCase(repository)
    }
}
