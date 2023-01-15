package com.farshatov.feature_search_wheather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class SearchWeatherState<out T : Any> : ViewState {
    data class Loading(val search: String? = null) : SearchWeatherState<Nothing>()
    data class Success<out T : Any>(val data: T?) : SearchWeatherState<T>()
    data class Error(val error: String) : SearchWeatherState<Nothing>()
}
