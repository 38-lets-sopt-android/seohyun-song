package com.example.letssopt.navigation

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val loginId: String = "",
    val password: String = ""
)

@Serializable
data object SignUp

@Serializable
data object MainRoute

@Serializable
data class Profile(val userId: Int)

@Serializable
data class HomeRoute(val userId: Int)

sealed class MainTabRoute

@Serializable data object Home : MainTabRoute()
@Serializable data object Purchase : MainTabRoute()
@Serializable data object Webtoon : MainTabRoute()
@Serializable data object Search : MainTabRoute()
@Serializable data object Folder : MainTabRoute()