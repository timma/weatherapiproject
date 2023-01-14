package com.farshatov.common.navigation

import com.farshatov.common.R

sealed class NavigationItem(
    val route: String,
    val title: Int,
    val icon: Int = R.drawable.ic_baseline_home_24,
    val navBack: String = ""
) {
    object CurrentWeather : NavigationItem(
        route = "current_weather",
        title = R.string.current_weather,
        icon = R.drawable.ic_round_ac_unit_24,
        navBack = ""
    )

    object SearchWeather :
        NavigationItem(
            route = "search_weather",
            title = R.string.current_weather,
            icon = R.drawable.ic_baseline_search_24,
            navBack = ""
        )

    object HistoryWeather : NavigationItem(
        route = "history_weather",
        title = R.string.history_weather,
        icon = R.drawable.ic_round_history_toggle_off_24,
        navBack = ""
    )

    object Sports : NavigationItem(
        route = "sports_weather",
        title = R.string.sports,
        icon = R.drawable.ic_round_sports_handball_24,
        navBack = ""
    )

    object AstronomyWeather :
        NavigationItem(
            route = "astronomy_weather",
            title = R.string.current_weather,
            icon = R.drawable.ic_round_wb_sunny_24,
            navBack = ""
        )
}
