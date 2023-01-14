package com.farshatov.weather.navGraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.farshatov.common.expanded.composable
import com.farshatov.common.navigation.NavigationItem
import com.farshatov.feature_current_weather.presentation.screen.CurrentWeatherScreen
import com.farshatov.feature_history_weather.screen.HistoryWeatherScreen
import com.farshatov.feature_search_wheather.screen.SearchWeatherScreen
import com.farshatov.feature_sports.presentation.screen.SportsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    startLocation: String
) {
    val context = LocalContext.current
    AnimatedNavHost(
        navController = navController,
        startDestination = startLocation
    ) {
        composable(
            route = NavigationItem.CurrentWeather.route,
            label = context.getString(NavigationItem.CurrentWeather.title)
        ) {
            CurrentWeatherScreen(
                title = stringResource(id = NavigationItem.CurrentWeather.title),
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }
        composable(
            route = NavigationItem.Sports.route,
            label = context.getString(NavigationItem.Sports.title)
        ) {
            SportsScreen(
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }
        composable(
            route = NavigationItem.SearchWeather.route,
            label = context.getString(NavigationItem.SearchWeather.title)
        ) {
            SearchWeatherScreen(
                title = stringResource(id = NavigationItem.CurrentWeather.title),
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }
        composable(
            route = NavigationItem.HistoryWeather.route,
            label = context.getString(NavigationItem.HistoryWeather.title)
        ) {
            HistoryWeatherScreen(
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }
    }
}
