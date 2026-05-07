package com.example.letssopt.navigation

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val email: String = "",
    val password: String = ""
)

@Serializable
data object SignUp

@Serializable
data object MainRoute

sealed class MainTabRoute

@Serializable data object Home : MainTabRoute()
@Serializable data object Purchase : MainTabRoute()
@Serializable data object Webtoon : MainTabRoute()
@Serializable data object Search : MainTabRoute()
@Serializable data object Folder : MainTabRoute()