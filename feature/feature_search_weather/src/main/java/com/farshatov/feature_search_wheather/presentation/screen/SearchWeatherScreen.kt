package com.farshatov.feature_search_wheather.presentation.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_search_wheather.presentation.viewmodel.SearchWeatherViewModel

@Composable
fun SearchWeatherScreen(
    navigateTo: (String) -> Unit,
    viewModel: SearchWeatherViewModel = hiltViewModel()
) {
}
