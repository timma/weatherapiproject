package com.farshatov.feature_current_weather.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherEvent
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherState
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherViewModel
import com.farshatov.uikit.component.WeatherItem
import com.farshatov.uikit.resources.UiColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CurrentWeatherScreen(
    navigateTo: (String) -> Unit,
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    var currentWeatherModel: CurrentWeatherModel? = null
    refreshing = when (uiState) {
        is CurrentWeatherState.Loading -> {
            viewModel.perform(CurrentWeatherEvent.Loading)
            true
        }
        is CurrentWeatherState.Error -> {
            // viewModel.perform(CurrentWeatherEvent.Error)
            false
        }
        is CurrentWeatherState.Success<*> -> {
            currentWeatherModel = uiState.data as CurrentWeatherModel
            false
        }
    }
    val state = rememberPullRefreshState(
        refreshing,
        onRefresh = { viewModel.perform(CurrentWeatherEvent.Loading) }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(state)
    ) {
        if (refreshing) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = UiColors.BLACK_OPACITY60.value
            ) { }
        } else {
            WeatherItem(
                precipMm = (currentWeatherModel?.current?.precipMm ?: 0.0).toString(),
                windKph = (currentWeatherModel?.current?.windKph ?: 0.0).toString(),
                tempC = (currentWeatherModel?.current?.tempC ?: 0.0).toString(),
                feelslikeC = (currentWeatherModel?.current?.feelslikeC ?: 0.0).toString(),
                humidity = (currentWeatherModel?.current?.humidity ?: 0.0).toString(),
                gustKph = (currentWeatherModel?.current?.gustKph ?: 0.0).toString()
            )
        }
        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
