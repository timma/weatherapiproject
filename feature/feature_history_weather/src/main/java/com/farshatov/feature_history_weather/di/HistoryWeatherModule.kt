package com.farshatov.feature_history_weather.di

import com.farshatov.core.location.LocationManager
import com.farshatov.feature_history_weather.data.remote.HistoryWeatherService
import com.farshatov.feature_history_weather.data.repository.HistoryWeatherRepositoryImpl
import com.farshatov.feature_history_weather.domain.repository.HistoryWeatherRepository
import com.farshatov.feature_history_weather.domain.usecase.GetHistoryWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class HistoryWeatherModule {
    @Provides
    @Singleton
    fun provideHistoryWeatherService(retrofit: Retrofit): HistoryWeatherService = retrofit.create(
        HistoryWeatherService::class.java
    )

    @Provides
    @Singleton
    fun provideHistoryWeatherRepository(
        api: HistoryWeatherService,
        locationManager: LocationManager
    ): HistoryWeatherRepository {
        return HistoryWeatherRepositoryImpl(api, locationManager)
    }

    @Provides
    @Singleton
    fun provideGetHistoryWeatherUseCase(repository: HistoryWeatherRepository): GetHistoryWeatherUseCase {
        return GetHistoryWeatherUseCase(repository)
    }
}
