package com.farshatov.feature_search_wheather.viewmodel

import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryWeatherViewModel @Inject constructor() :
    BaseViewModel<HistoryWeatherEvent, HistoryWeatherState, ViewCommand>() {
    override val initialState: HistoryWeatherState
        get() = TODO("Not yet implemented")

    override fun perform(viewEvent: HistoryWeatherEvent) {
        TODO("Not yet implemented")
    }
}
