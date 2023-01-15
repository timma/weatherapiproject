package com.farshatov.feature_sports.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.common.model.Sports
import com.farshatov.feature_sports.domain.model.SportsModel
import com.farshatov.feature_sports.presentation.viewmodel.SportsEvent
import com.farshatov.feature_sports.presentation.viewmodel.SportsState
import com.farshatov.feature_sports.presentation.viewmodel.SportsViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportsScreen(
    navigateTo: (String) -> Unit,
    viewModel: SportsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    var sportsModel: SportsModel? = null
    refreshing = when (uiState) {
        is SportsState.Loading -> {
            viewModel.perform(SportsEvent.Load)
            true
        }
        is SportsState.Error -> {
            false
        }
        is SportsState.Success<*> -> {
            sportsModel = uiState.data as SportsModel
            false
        }
    }
    val state =
        rememberPullRefreshState(refreshing, onRefresh = { viewModel.perform(SportsEvent.Load) })
    val listState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize().pullRefresh(state)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState
        ) {
            sportsModel?.let { sportsModel ->
                items(sportsModel.football.size) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = defaultPadding),
                        elevation = 4.dp
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = sportsModel.football[item].start,
                                    color = UiColors.BLUE.value,
                                    style = UiTextStyle.TITLE_BODY.style
                                )
                                Text(
                                    text = sportsModel.football[item].country,
                                    color = UiColors.BLUE.value,
                                    style = UiTextStyle.TITLE_BODY.style
                                )
                            }
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                text = sportsModel.football[item].tournament,
                                style = UiTextStyle.H1.style
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = Sports.FOOTBALL.value,
                                    color = UiColors.GREEN.value
                                )
                                Text(
                                    text = sportsModel.football[item].match,
                                    color = UiColors.RED.value
                                )
                            }
                        }
                    }
                }
                items(sportsModel.cricket.size) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = defaultPadding),
                        elevation = 4.dp
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = sportsModel.football[item].start,
                                    color = UiColors.BLUE.value,
                                    style = UiTextStyle.TITLE_BODY.style
                                )
                                Text(
                                    text = sportsModel.football[item].country,
                                    color = UiColors.BLUE.value,
                                    style = UiTextStyle.TITLE_BODY.style
                                )
                            }
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                text = sportsModel.football[item].tournament,
                                style = UiTextStyle.H1.style
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = defaultPadding),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = Sports.CRICKET.value,
                                    color = UiColors.GREEN.value
                                )
                                Text(
                                    text = sportsModel.football[item].match,
                                    color = UiColors.RED.value
                                )
                            }
                        }
                    }
                }
            }
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
