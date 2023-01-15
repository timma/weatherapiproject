package com.farshatov.feature_current_weather.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherEvent
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherState
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CurrentWeatherScreen(
    navigateTo: (String) -> Unit,
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
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
            false
        }
    }
    val state = rememberPullRefreshState(refreshing, onRefresh = { viewModel.perform(CurrentWeatherEvent.Loading) })

    Box(modifier = Modifier.fillMaxSize().pullRefresh(state)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = defaultPadding)
                .verticalScroll(rememberScrollState())
        ) {
        }
        if (refreshing) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = UiColors.BLACK_OPACITY60.value
            ) { }
        }
        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
