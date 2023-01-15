package com.farshatov.feature_current_weather.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.common.network.Result
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.domain.usecase.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val currentWeatherUseCase: GetCurrentWeatherUseCase
) :
    BaseViewModel<CurrentWeatherEvent, CurrentWeatherState<CurrentWeatherModel>, ViewCommand>() {
    override val initialState: CurrentWeatherState<CurrentWeatherModel>
        get() = CurrentWeatherState.Loading

    override fun perform(viewEvent: CurrentWeatherEvent) {
        when (viewEvent) {
            is CurrentWeatherEvent.Loading -> loadCurrentWeather()
        }
    }

    fun loadCurrentWeather() = viewModelScope.launch {
        currentWeatherUseCase.invoke().collectLatest {
            when (it) {
                is Result.Success -> {
                    it.data?.let { data ->
                        updateState(
                            CurrentWeatherState.Success(
                                data = data
                            )
                        )
                    }
                }
                is Result.Error -> {
                    updateState(
                        CurrentWeatherState.Error(
                            it.message.orEmpty()
                        )
                    )
                }
                is Result.Loading -> {
                    updateState(CurrentWeatherState.Loading)
                }
                else -> {}
            }
        }
    }
}
