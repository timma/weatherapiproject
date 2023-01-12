package com.farshatov.feature_current_weather.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_current_weather.presentation.viewmodel.CurrentWeatherViewModel
import com.farshatov.uikit.TitleString
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.defaultPadding

@Composable
fun CurrentWeatherScreen(
    title: String,
    navigateTo: (String) -> Unit,
    spaceViewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(all = defaultPadding)) {
        TitleString(
            modifier = Modifier.drawBehind {
                drawLine(
                    color = UiColors.BLUE.value,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            },
            title = title
        )
    }
}
