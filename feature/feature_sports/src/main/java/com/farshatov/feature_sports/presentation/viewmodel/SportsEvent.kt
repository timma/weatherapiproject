package com.farshatov.feature_sports.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.ViewEvent

open class SportsEvent : ViewEvent {
    object Load : SportsEvent()
}
