package com.farshatov.feature_sports.presentation.screen

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
import com.farshatov.feature_sports.presentation.viewmodel.SportsEvent
import com.farshatov.feature_sports.presentation.viewmodel.SportsState
import com.farshatov.feature_sports.presentation.viewmodel.SportsViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportsScreen(
    navigateTo: (String) -> Unit,
    viewModel: SportsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    refreshing = when (uiState) {
        is SportsState.Loading -> {
            viewModel.perform(SportsEvent.Load)
            true
        }
        is SportsState.Error -> {
            false
        }
        is SportsState.Success<*> -> {
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
            /*LazyColumn(content =){
                items(uiState.sportsList.size) { index ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = defaultPadding),
                        color = UiColors.surface
                    ) {
                        SportsItem(
                            sport = uiState.sportsList[index],
                            navigateTo = navigateTo
                        )
                    }
                }
            }*/
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
