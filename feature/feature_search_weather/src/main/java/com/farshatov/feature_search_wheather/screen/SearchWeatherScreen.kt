package com.farshatov.feature_search_wheather.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_search_wheather.viewmodel.SearchWeatherViewModel
import com.farshatov.uikit.TitleString

@Composable
fun SearchWeatherScreen(
    title: String,
    navigateTo: (String) -> Unit,
    spaceViewModel: SearchWeatherViewModel = hiltViewModel()
) {
    TitleString(title = title)
}
