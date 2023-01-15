package com.farshatov.feature_current_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class CurrentWeatherState<out T : Any> : ViewState {
    object Loading : CurrentWeatherState<Nothing>()
    data class Success<out T : Any>(val data: T) : CurrentWeatherState<T>()
    data class Error(val errorMessage: String) : CurrentWeatherState<Nothing>()
}
