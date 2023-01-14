package com.farshatov.feature_sports.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.common.network.Result
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import com.farshatov.feature_sports.domain.model.SportsModel
import com.farshatov.feature_sports.domain.usecase.GetSportsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val sportsUseCase: GetSportsUseCase
) :
    BaseViewModel<SportsEvent, SportsState<SportsModel>, ViewCommand>() {
    override val initialState: SportsState<SportsModel>
        get() = SportsState.Loading

    override fun perform(viewEvent: SportsEvent) {
        when (viewEvent) {
            is SportsEvent.Load -> loadSports()
        }
    }

    fun loadSports() = viewModelScope.launch {
        sportsUseCase.invoke().collectLatest {
            when (it) {
                is Result.Success -> {
                    it.data?.let { data ->
                        updateState(
                            SportsState.Success(
                                data = data
                            )
                        )
                    }
                }
//                is Result.Error -> {
//                    updateState(CurrentWeatherState.Error(it.message))
//                }
                is Result.Loading -> {
                    updateState(SportsState.Loading)
                }
                else -> {}
            }
        }
    }
}
