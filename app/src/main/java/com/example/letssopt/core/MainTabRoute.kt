package com.example.letssopt.core

import kotlinx.serialization.Serializable


sealed class MainTabRoute

@Serializable data object Home : MainTabRoute()
@Serializable data object Purchase : MainTabRoute()
@Serializable data object Webtoon : MainTabRoute()
@Serializable data object Search : MainTabRoute()
@Serializable data object Folder : MainTabRoute()