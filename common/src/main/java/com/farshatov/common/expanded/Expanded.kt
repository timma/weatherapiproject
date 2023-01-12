package com.farshatov.common.expanded

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.get
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composable(
    route: String,
    label: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
    popEnterTransition: (
        AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?
    )? = enterTransition,
    popExitTransition: (
        AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?
    )? = exitTransition,
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    addDestination(
        AnimatedComposeNavigator.Destination(
            provider[AnimatedComposeNavigator::class],
            content
        ).apply {
            this.route = route
            this.label = label
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
            enterTransition?.let { enterTransitions[route] = enterTransition }
            exitTransition?.let { exitTransitions[route] = exitTransition }
            popEnterTransition?.let { popEnterTransitions[route] = popEnterTransition }
            popExitTransition?.let { popExitTransitions[route] = popExitTransition }
        }
    )
}

@ExperimentalAnimationApi
internal val enterTransitions =
    mutableMapOf<String?,
        (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)?>()

@ExperimentalAnimationApi
internal val exitTransitions =
    mutableMapOf<String?, (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)?>()

@ExperimentalAnimationApi
internal val popEnterTransitions =
    mutableMapOf<String?, (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)?>()

@ExperimentalAnimationApi
internal val popExitTransitions =
    mutableMapOf<String?, (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)?>()
