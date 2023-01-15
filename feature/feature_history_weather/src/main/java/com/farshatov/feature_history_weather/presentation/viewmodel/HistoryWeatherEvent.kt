package com.farshatov.feature_history_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

open class HistoryWeatherEvent : ViewEvent {
    object Loading : HistoryWeatherEvent()
}
