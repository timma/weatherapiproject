package com.farshatov.feature_sports.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class SportsState<out T : Any> : ViewState {
    object Loading : SportsState<Nothing>()
    data class Success<out T : Any>(val data: T) : SportsState<T>()
    data class Error(val error: Throwable) : SportsState<Nothing>()
}
