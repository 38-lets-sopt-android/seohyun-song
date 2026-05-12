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
data class Profile(val userId: Int)