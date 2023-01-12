package com.farshatov.uikit.resources

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val screenEdgeOffset = 16.dp
val defaultPadding = 16.dp

fun Modifier.defaultPadding() = padding(
    horizontal = defaultPadding,
    vertical = defaultPadding
)
