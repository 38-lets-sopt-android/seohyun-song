package com.example.letssopt.presentation.home

import com.example.letssopt.presentation.home.model.ContentItem
import com.example.letssopt.presentation.home.model.WatchaPartyItem

data class HomeUiState(
    val newContents: List<ContentItem> = emptyList(),
    val watGorithm: List<ContentItem> = emptyList(),
    val upComing: List<ContentItem> = emptyList(),
    val watchaParty: List<WatchaPartyItem> = emptyList()
)