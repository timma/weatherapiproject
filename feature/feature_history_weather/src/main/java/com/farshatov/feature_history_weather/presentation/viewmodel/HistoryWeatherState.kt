package com.farshatov.feature_history_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class HistoryWeatherState<out T : Any> : ViewState {
    object Loading : HistoryWeatherState<Nothing>()
    data class Success<out T : Any>(val data: T) : HistoryWeatherState<T>()
    data class Error(val error: String) : HistoryWeatherState<Nothing>()
}
