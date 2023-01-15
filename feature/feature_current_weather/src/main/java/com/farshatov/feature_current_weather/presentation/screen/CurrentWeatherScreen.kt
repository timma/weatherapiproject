package com.farshatov.feature_current_weather.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.common.R
import com.farshatov.feature_current_weather.domain.model.CurrentWeatherModel
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherEvent
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherState
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = defaultPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = defaultPadding),
                elevation = 4.dp
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(
                                start = defaultPadding,
                                end = defaultPadding,
                                top = defaultPadding
                            )
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.precip_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = stringResource(id = R.string.windSpeed_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = defaultPadding,
                                end = defaultPadding,
                                bottom = defaultPadding
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = currentWeatherModel?.current?.precipMm.toString(),
                            color = UiColors.RED.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = currentWeatherModel?.current?.windKph.toString(),
                            color = UiColors.RED.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(
                                start = defaultPadding,
                                end = defaultPadding
                            ),
                        textAlign = TextAlign.Center,
                        text = (
                            currentWeatherModel?.current?.tempC
                                ?: 0
                            ).toString() + stringResource(id = R.string.celsius),
                        style = UiTextStyle.H1.style
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.feelslikeTemp) + " " +
                            (currentWeatherModel?.current?.feelslikeC ?: 0).toString() +
                            stringResource(id = R.string.celsius),
                        style = UiTextStyle.TITLE_BODY.style
                    )
                    Row(
                        modifier = Modifier
                            .padding(
                                start = defaultPadding,
                                end = defaultPadding,
                                top = defaultPadding
                            )
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.humidity_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = stringResource(id = R.string.gust_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = defaultPadding,
                                end = defaultPadding,
                                bottom = defaultPadding
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = currentWeatherModel?.current?.humidity.toString(),
                            color = UiColors.RED.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = currentWeatherModel?.current?.gustKph.toString(),
                            color = UiColors.RED.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
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
