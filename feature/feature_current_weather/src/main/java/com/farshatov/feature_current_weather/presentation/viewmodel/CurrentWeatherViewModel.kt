package com.farshatov.feature_current_weather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor() :
    BaseViewModel<CurrentWeatherEvent, CurrentWeatherState, ViewCommand>() {
    override val initialState: CurrentWeatherState
        get() = TODO("Not yet implemented")

    override fun perform(viewEvent: CurrentWeatherEvent) {
        TODO("Not yet implemented")
    }
}
