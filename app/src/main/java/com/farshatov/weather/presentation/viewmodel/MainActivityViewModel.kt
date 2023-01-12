package com.farshatov.weather.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor() :
    BaseViewModel<MainEvent, MainState, ViewCommand>() {

    override val initialState = MainState.Loading

    override fun perform(viewEvent: MainEvent) {
        with(viewEvent) {
            when (this) {
                is MainEvent.Load -> onLoad()
            }
        }
    }

    private fun onLoad() = viewModelScope.launch {
        updateState(
            MainState.Success
        )
    }
}
