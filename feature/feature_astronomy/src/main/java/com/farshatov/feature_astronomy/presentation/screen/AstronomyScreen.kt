package com.farshatov.feature_astronomy.presentation.screen

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
import com.farshatov.feature_astronomy.domain.model.AstronomyOutputModel
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyEvent
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyState
import com.farshatov.feature_astronomy.presentation.viewmodel.AstronomyViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AstronomyScreen(
    navigateTo: (String) -> Unit,
    viewModel: AstronomyViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    var astronomyOutputModel: AstronomyOutputModel? = null
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
            astronomyOutputModel = uiState.data as AstronomyOutputModel
            false
        }
        else -> {
            false
        }
    }
    val state = rememberPullRefreshState(
        refreshing,
        onRefresh = { viewModel.perform(AstronomyEvent.Loading) }
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
                            text = stringResource(id = com.farshatov.common.R.string.moonrise_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = stringResource(id = com.farshatov.common.R.string.moonset_string),
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
                            text = astronomyOutputModel?.astronomy?.astro?.moonrise.orEmpty(),
                            color = UiColors.BLUE.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = astronomyOutputModel?.astronomy?.astro?.moonset.orEmpty(),
                            color = UiColors.BLUE.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(all = defaultPadding),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = com.farshatov.common.R.string.moonIllumination) +
                            " " +
                            astronomyOutputModel?.astronomy?.astro?.moonIllumination.orEmpty(),
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
                            text = stringResource(id = com.farshatov.common.R.string.sunrise_string),
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = stringResource(id = com.farshatov.common.R.string.sunset_string),
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
                            text = astronomyOutputModel?.astronomy?.astro?.sunrise.orEmpty(),
                            color = UiColors.RED.value,
                            style = UiTextStyle.TITLE_BODY.style
                        )
                        Text(
                            text = astronomyOutputModel?.astronomy?.astro?.sunset.orEmpty(),
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
