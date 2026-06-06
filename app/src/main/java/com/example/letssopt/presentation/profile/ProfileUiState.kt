package com.example.letssopt.presentation.profile

data class ProfileUiState(
    val id: Int = 0,
    val loginId: String = "",
    val name: String = "",
    val email: String = "",
    val age: Int = 0,
    val part: String = ""
)

sealed class ProfileUiEvent {
    data class ShowToast(val message: String) : ProfileUiEvent()
}