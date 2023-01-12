package com.farshatov.feature_sports.viewmodel

import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor() :
    BaseViewModel<SportsEvent, SportsState, ViewCommand>() {
    override val initialState: SportsState
        get() = TODO("Not yet implemented")

    override fun perform(viewEvent: SportsEvent) {
        TODO("Not yet implemented")
    }
}
