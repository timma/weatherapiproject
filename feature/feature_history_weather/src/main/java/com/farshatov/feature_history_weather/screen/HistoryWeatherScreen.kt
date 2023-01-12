package com.farshatov.feature_history_weather.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_search_wheather.viewmodel.HistoryWeatherViewModel

@Composable
fun HistoryWeatherScreen(
    navigateTo: (String) -> Unit,
    spaceViewModel: HistoryWeatherViewModel = hiltViewModel()
) {
}
