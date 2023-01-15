package com.farshatov.feature_history_weather.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.common.network.Result
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import com.farshatov.feature_history_weather.domain.usecase.GetHistoryWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class HistoryWeatherViewModel @Inject constructor(
    private val getHistoryWeatherUseCase: GetHistoryWeatherUseCase
) :
    BaseViewModel<HistoryWeatherEvent, HistoryWeatherState<HistoryWeatherOutputModel>, ViewCommand>() {
    override val initialState: HistoryWeatherState<HistoryWeatherOutputModel>
        get() = HistoryWeatherState.Loading

    override fun perform(viewEvent: HistoryWeatherEvent) {
        when (viewEvent) {
            is HistoryWeatherEvent.Loading -> {
                /*updateState(
                    HistoryWeatherState.Error(
                        "Error Test test"
                    )
                )*/
                loadHistoryWeatherOutputModel()
            }
        }
    }

    fun loadHistoryWeatherOutputModel() = viewModelScope.launch {
        getHistoryWeatherUseCase.invoke().collectLatest {
            when (it) {
                is Result.Success -> {
                    it.data?.let { data ->
                        updateState(
                            HistoryWeatherState.Success(
                                data = data
                            )
                        )
                    }
                }
                is Result.Error -> {
                    updateState(
                        HistoryWeatherState.Error(
                            it.message.orEmpty()
                        )
                    )
                }
                is Result.Loading -> {
                    updateState(HistoryWeatherState.Loading)
                }
                else -> {}
            }
        }
    }
}
