package com.farshatov.weather.presentation.view

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farshatov.common.navigation.NavigationItem
import com.farshatov.core.location.LocationManager
import com.farshatov.core.location.LocationW
import com.farshatov.uikit.PopBottomNavigation
import com.farshatov.uikit.resources.UiColors
import com.farshatov.uikit.resources.WeatherTheme
import com.farshatov.weather.navGraph.NavigationGraph
import com.farshatov.weather.presentation.viewmodel.MainActivityViewModel
import com.farshatov.weather.presentation.viewmodel.MainEvent
import com.farshatov.weather.presentation.viewmodel.MainState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class, ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        var location: LocationW? = null
        val splashScreen = installSplashScreen()
        val locationManager = LocationManager(this)
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = viewModel.uiState().collectAsState().value

            splashScreen.setKeepOnScreenCondition {
                when (uiState) {
                    MainState.Loading -> true
                    MainState.Success -> false
                }
            }

            if (uiState is MainState.Success) {
                val permissionsState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )

                permissionsState.permissions.forEach { permission ->
                    when (permission.status) {
                        PermissionStatus.Granted -> {
                            LaunchedEffect(Unit) {
                                location = locationManager.getLastKnownLocation()
                            }
                        }
                        is PermissionStatus.Denied -> {
                            LaunchedEffect(key1 = true) {
                                permissionsState.launchMultiplePermissionRequest()
                            }
                        }
                    }
                }
            }

            val systemUiController = rememberSystemUiController()
            val darkTheme = isSystemInDarkTheme()

            DisposableEffect(systemUiController, darkTheme) {
                systemUiController.setSystemBarsColor(Color.Transparent)
                systemUiController.systemBarsDarkContentEnabled = !darkTheme
                onDispose {}
            }
            WeatherTheme {
                val navController = rememberAnimatedNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val title = currentBackStackEntry?.destination?.label
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = title.toString()) },
                            backgroundColor = UiColors.BLUE.value
                        )
                    },
                    bottomBar = {
                        PopBottomNavigation(
                            navController = navController,
                            items = listOf(
                                NavigationItem.CurrentWeather,
                                NavigationItem.SearchWeather,
                                NavigationItem.HistoryWeather,
                                NavigationItem.Sports,
                                NavigationItem.AstronomyWeather
                            )
                        )
                    }
                ) { innerPadding ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize().padding(
                            PaddingValues(0.dp, 0.dp, 0.dp, innerPadding.calculateBottomPadding())
                        )
                    ) {
                        NavigationGraph(
                            navController,
                            NavigationItem.CurrentWeather.route
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.perform(MainEvent.Load)
    }
}
