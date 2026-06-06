package com.example.letssopt.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeRoute(
    navigateToProfile: () -> Unit
) {
    val viewModel: HomeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        newContents = uiState.newContents,
        watGorithm = uiState.watGorithm,
        upComing = uiState.upComing,
        navigateToProfile = navigateToProfile,
        watchaParty = uiState.watchaParty
    )
}