package com.farshatov.feature_search_wheather.di

import com.farshatov.feature_search_wheather.data.remote.SearchWeatherService
import com.farshatov.feature_search_wheather.data.repository.SearchWeatherRepositoryImpl
import com.farshatov.feature_search_wheather.domain.repository.SearchWeatherRepository
import com.farshatov.feature_search_wheather.domain.usecase.SearchWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SearchWeatherModule {
    @Provides
    @Singleton
    fun provideSearchWeatherService(retrofit: Retrofit): SearchWeatherService = retrofit.create(
        SearchWeatherService::class.java
    )

    @Provides
    @Singleton
    fun provideAstronomyRepository(
        api: SearchWeatherService
    ): SearchWeatherRepository {
        return SearchWeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetAstronomyUseCase(repository: SearchWeatherRepository): SearchWeatherUseCase {
        return SearchWeatherUseCase(repository)
    }
}
