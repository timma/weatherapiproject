package com.farshatov.feature_search_wheather.presentation.viewmodel

import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchWeatherViewModel @Inject constructor() :
    BaseViewModel<SearchWeatherEvent, SearchWeatherState, ViewCommand>() {
    override val initialState: SearchWeatherState
        get() = TODO("Not yet implemented")

    override fun perform(viewEvent: SearchWeatherEvent) {
        TODO("Not yet implemented")
    }
}
