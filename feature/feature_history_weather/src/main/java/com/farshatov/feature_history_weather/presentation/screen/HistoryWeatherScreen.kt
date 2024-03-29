package com.farshatov.feature_history_weather.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_history_weather.domain.model.HistoryWeatherOutputModel
import com.farshatov.feature_history_weather.presentation.viewmodel.HistoryWeatherEvent
import com.farshatov.feature_history_weather.presentation.viewmodel.HistoryWeatherState
import com.farshatov.feature_history_weather.presentation.viewmodel.HistoryWeatherViewModel
import com.farshatov.uikit.component.WeatherItem
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HistoryWeatherScreen(
    navigateTo: (String) -> Unit,
    viewModel: HistoryWeatherViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    var isError = ""
    var historyWeatherOutputModel: HistoryWeatherOutputModel? = null
    refreshing = when (uiState) {
        is HistoryWeatherState.Loading -> {
            viewModel.perform(HistoryWeatherEvent.Loading)
            true
        }
        is HistoryWeatherState.Error -> {
            isError = uiState.error
            false
        }
        is HistoryWeatherState.Success<*> -> {
            historyWeatherOutputModel = uiState.data as HistoryWeatherOutputModel
            false
        }
    }
    val state = rememberPullRefreshState(
        refreshing,
        onRefresh = { viewModel.perform(HistoryWeatherEvent.Loading) }
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
            if (isError.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        Icons.Rounded.Close,
                        contentDescription = "",
                        tint = UiColors.RED.value,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(text = isError, style = UiTextStyle.H1.style)
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    state = listState
                ) {
                    historyWeatherOutputModel?.let { historyWeather ->
                        items(historyWeather.forecast.forecastday.first().hour.size) { index ->
                            val hourModel = historyWeather.forecast.forecastday.first().hour[index]
                            Text(
                                text = hourModel.time,
                                style = UiTextStyle.H1.style,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = defaultPadding)
                            )
                            WeatherItem(
                                modifier = Modifier.padding(horizontal = defaultPadding),
                                precipMm = (hourModel.precipMm).toString(),
                                windKph = (hourModel.windKph).toString(),
                                tempC = (hourModel.tempC).toString(),
                                feelslikeC = hourModel.feelslikeC.toString(),
                                humidity = (hourModel.humidity).toString(),
                                gustKph = (hourModel.gustKph).toString()
                            )
                        }
                    }
                }
            }
        }
        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
