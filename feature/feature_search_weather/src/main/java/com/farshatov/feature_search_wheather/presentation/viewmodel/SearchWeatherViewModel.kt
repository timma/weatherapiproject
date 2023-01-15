package com.farshatov.feature_search_wheather.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.farshatov.common.network.Result
import com.farshatov.core.presentation.viewmodel.BaseViewModel
import com.farshatov.core.presentation.viewmodel.ViewCommand
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel
import com.farshatov.feature_search_wheather.domain.usecase.SearchWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class SearchWeatherViewModel @Inject constructor(
    private val searchWeatherUseCase: SearchWeatherUseCase
) :
    BaseViewModel<SearchWeatherEvent, SearchWeatherState<SearchWeatherOutputModel>, ViewCommand>() {
    override val initialState: SearchWeatherState<SearchWeatherOutputModel>
        get() = SearchWeatherState.Loading(null)

    override fun perform(viewEvent: SearchWeatherEvent) {
        when (viewEvent) {
            is SearchWeatherEvent.Loading -> loadSearchWeather(viewEvent.search)
        }
    }

    private fun loadSearchWeather(search: String) = viewModelScope.launch {
        if (search.isEmpty()) {
            updateState(
                SearchWeatherState.Success(
                    null
                )
            )
        } else {
            searchWeatherUseCase.invoke(search).collectLatest {
                when (it) {
                    is Result.Success -> {
                        it.data?.let { data ->
                            updateState(
                                SearchWeatherState.Success(
                                    data = data
                                )
                            )
                        }
                    }
                    is Result.Error -> {
                        updateState(
                            SearchWeatherState.Error(
                                it.message.orEmpty()
                            )
                        )
                    }
                    is Result.Loading -> {
                        updateState(SearchWeatherState.Loading(""))
                    }
                    else -> {}
                }
            }
        }
    }
}
