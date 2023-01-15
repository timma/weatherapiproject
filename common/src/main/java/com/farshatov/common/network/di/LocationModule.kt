package com.farshatov.common.network.di

import android.content.Context
import com.farshatov.core.location.LocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    companion object {

        @Provides
        @Singleton
        fun provideGeoProvider(@ApplicationContext context: Context): LocationManager =
            LocationManager(context)
    }
}
