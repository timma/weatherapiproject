package com.farshatov.feature_astronomy.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyEvent
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyState
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AstronomyScreen(
    navigateTo: (String) -> Unit,
    viewModel: AstronomyViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    refreshing = when (uiState) {
        is AstronomyState.Loading -> {
            viewModel.perform(AstronomyEvent.Loading)
            true
        }
        is AstronomyState.Error -> {
            // viewModel.perform(AstronomyEvent.Error)
            false
        }
        is AstronomyState.Success<*> -> {
            false
        }
        else -> {
            false
        }
    }
    val state = rememberPullRefreshState(refreshing, onRefresh = { refreshing = true })

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = defaultPadding)
                .pullRefresh(state)
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
