package com.farshatov.feature_astronomy.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class AstronomyState<out T : Any> : ViewState {
    object Loading : AstronomyState<Nothing>()
    data class Success<out T : Any>(val data: T) : AstronomyState<T>()
    data class Error(val error: Throwable) : AstronomyState<Nothing>()
}
