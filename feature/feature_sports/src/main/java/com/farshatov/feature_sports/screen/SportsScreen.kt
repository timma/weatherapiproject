package com.farshatov.feature_sports.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.farshatov.feature_sports.viewmodel.SportsViewModel

@Composable
fun SportsScreen(
    navigateTo: (String) -> Unit,
    spaceViewModel: SportsViewModel = hiltViewModel()
) {
}
