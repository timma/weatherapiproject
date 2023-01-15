package com.farshatov.feature_search_wheather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

open class SearchWeatherEvent : ViewEvent {
    data class Loading(val search: String) : SearchWeatherEvent()
}
