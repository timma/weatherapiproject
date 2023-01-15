package com.farshatov.feature_search_wheather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class SearchWeatherState : ViewState {
    object Loading : SearchWeatherState()
    data class Success(val data: String) : SearchWeatherState()
    data class Error(val error: Throwable) : SearchWeatherState()
}
