package com.farshatov.feature_search_wheather.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class HistoryWeatherState : ViewState {
    object Loading : HistoryWeatherState()
    data class Success(val data: String) : HistoryWeatherState()
    data class Error(val error: Throwable) : HistoryWeatherState()
}
