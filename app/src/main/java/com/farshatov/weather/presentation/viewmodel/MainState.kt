package com.farshatov.weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewState

sealed class MainState : ViewState {
    object Loading : MainState()
    object Success : MainState()
}
