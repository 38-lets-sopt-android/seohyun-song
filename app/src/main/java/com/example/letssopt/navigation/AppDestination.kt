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
data object Home

@Serializable
data object Purchase

@Serializable
data object Webtoon

@Serializable
data object Search

@Serializable
data object Folder