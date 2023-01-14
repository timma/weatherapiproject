package com.farshatov.feature_current_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

open class CurrentWeatherEvent : ViewEvent {
    object Loading : CurrentWeatherEvent()
}
