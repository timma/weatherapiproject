package com.farshatov.feature_sports.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class SportsState : ViewState {
    object Loading : SportsState()
    data class Success(val data: String) : SportsState()
    data class Error(val error: Throwable) : SportsState()
}
