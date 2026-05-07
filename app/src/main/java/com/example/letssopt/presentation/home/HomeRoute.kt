package com.example.letssopt.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeRoute(
    innerPadding: PaddingValues
) {
    val viewModel: HomeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        innerPadding = innerPadding,
        newContents = uiState.newContents,
        watGorithm = uiState.watGorithm,
        upComing = uiState.upComing,
        watchaParty = uiState.watchaParty
    )
}