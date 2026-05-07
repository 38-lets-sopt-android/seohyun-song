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
    val newContents by viewModel.newContents.collectAsStateWithLifecycle()
    val watGorithm by viewModel.watGorithm.collectAsStateWithLifecycle()
    val upComing by viewModel.upComing.collectAsStateWithLifecycle()
    val watchaParty by viewModel.watchaParty.collectAsStateWithLifecycle()

    HomeScreen(
        innerPadding = innerPadding,
        newContents = newContents,
        watGorithm = watGorithm,
        upComing = upComing,
        watchaParty = watchaParty
    )
}