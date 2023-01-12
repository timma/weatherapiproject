package com.farshatov.weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

sealed class MainEvent : ViewEvent {
    object Load : MainEvent()
}
