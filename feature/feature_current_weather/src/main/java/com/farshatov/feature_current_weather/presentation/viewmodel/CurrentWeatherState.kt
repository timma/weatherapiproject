package com.farshatov.feature_current_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class CurrentWeatherState : ViewState {
    object Loading : CurrentWeatherState()
    data class Success(val data: String) : CurrentWeatherState()
    data class Error(val error: Throwable) : CurrentWeatherState()
}
