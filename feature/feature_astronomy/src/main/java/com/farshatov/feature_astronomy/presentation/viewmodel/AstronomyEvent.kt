package com.farshatov.feature_astronomy.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

open class AstronomyEvent : ViewEvent {
    object Loading : AstronomyEvent()
}
