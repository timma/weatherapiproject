package com.farshatov.feature_astronomy.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.common.network.Result
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import com.farshatov.feature_astronomy.domain.usecase.GetAstronomyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class AstronomyViewModel @Inject constructor(
    private val getAstronomyUseCase: GetAstronomyUseCase
) :
    BaseViewModel<AstronomyEvent, AstronomyState<AstronomyOutputModel>, ViewCommand>() {
    override val initialState: AstronomyState<AstronomyOutputModel>
        get() = AstronomyState.Loading

    override fun perform(viewEvent: AstronomyEvent) {
        when (viewEvent) {
            is AstronomyEvent.Loading -> loadAstronomyOutputModel()
        }
    }

    fun loadAstronomyOutputModel() = viewModelScope.launch {
        getAstronomyUseCase.invoke().collectLatest {
            when (it) {
                is Result.Success -> {
                    it.data?.let { data ->
                        updateState(
                            AstronomyState.Success(
                                data = data
                            )
                        )
                    }
                }
//                is Result.Error -> {
//                    updateState(AstronomyState.Error(it.message))
//                }
                is Result.Loading -> {
                    updateState(AstronomyState.Loading)
                }
                else -> {}
            }
        }
    }
}
