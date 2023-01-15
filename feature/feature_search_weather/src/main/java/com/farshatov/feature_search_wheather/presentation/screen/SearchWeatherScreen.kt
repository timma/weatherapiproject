package com.farshatov.feature_search_wheather.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_search_wheather.domain.model.SearchWeatherOutputModel
import com.farshatov.feature_search_wheather.presentation.viewmodel.SearchWeatherEvent
import com.farshatov.feature_search_wheather.presentation.viewmodel.SearchWeatherState
import com.farshatov.feature_search_wheather.presentation.viewmodel.SearchWeatherViewModel
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.UiTextStyle
import com.farshatov.uikit.resources.defaultPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchWeatherScreen(
    navigateTo: (String) -> Unit,
    viewModel: SearchWeatherViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState().collectAsState().value
    var refreshing by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    var isError = ""
    var searchWeatherOutputModel: SearchWeatherOutputModel? = null
    refreshing = when (uiState) {
        is SearchWeatherState.Loading -> {
            viewModel.perform(SearchWeatherEvent.Loading(""))
            true
        }
        is SearchWeatherState.Error -> {
            isError = uiState.error
            false
        }
        is SearchWeatherState.Success<*> -> {
            searchWeatherOutputModel = uiState.data as? SearchWeatherOutputModel
            false
        }
    }
    var text by remember { mutableStateOf("") }
    val state = rememberPullRefreshState(
        refreshing,
        onRefresh = { viewModel.perform(SearchWeatherEvent.Loading("")) }
    )
    Box(
        modifier = Modifier.fillMaxSize().pullRefresh(state)
    ) {
        if (refreshing) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = UiColors.BLACK_OPACITY60.value
            ) { }
        } else {
            if (isError.isNotEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
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
                    modifier = Modifier.fillMaxSize(),
                    state = listState
                ) {
                    item {
                        TextField(
                            modifier = Modifier.padding(
                                top = defaultPadding
                            ).padding(
                                horizontal = defaultPadding
                            ).height(IntrinsicSize.Min).fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = UiColors.CLICKABLE_PLATES.value,
                                focusedIndicatorColor = UiColors.WHITE.value,
                                unfocusedIndicatorColor = UiColors.WHITE.value,
                                disabledIndicatorColor = UiColors.WHITE.value
                            ),
                            shape = RoundedCornerShape(8.dp),
                            value = text,
                            onValueChange = {
                                text = it
                                viewModel.perform(SearchWeatherEvent.Loading(it))
                            },
                            leadingIcon = {
                                Icon(Icons.Filled.Search, contentDescription = null)
                            },
                            label = {
                                Text(
                                    text = stringResource(id = com.farshatov.common.R.string.search_text_string),
                                    style = UiTextStyle.TXT_S_SECOND_TXT.style
                                )
                            },
                            placeholder = {
                                Text(
                                    text = stringResource(
                                        id = com.farshatov.common.R.string.search_text_string
                                    )
                                )
                            }
                        )
                    }
                    searchWeatherOutputModel?.let { searchWeather ->
                        items(searchWeather.size) { index ->
                            Card(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(vertical = defaultPadding),
                                elevation = 4.dp
                            ) {
                                Text(
                                    text = searchWeather[index].name,
                                    style = UiTextStyle.H1.style,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(horizontal = defaultPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
    }
}
