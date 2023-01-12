package com.farshatov.uikit.resources

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColors(
    primary = UiColors.BLUE.value,
    background = UiColors.WHITE.value
)

@Composable
fun WeatherTheme(content: @Composable () -> Unit) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colors = colorScheme,
        typography = UiTypography,
        content = content
    )
}
