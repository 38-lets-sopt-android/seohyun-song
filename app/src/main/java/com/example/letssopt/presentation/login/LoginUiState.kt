package com.example.letssopt.presentation.login

data class LoginUiState(
    val loginIdInput: String = "",
    val pwInput: String = "",
)

sealed class LoginUiEvent {
    data class ShowToast(val message: String) : LoginUiEvent()
    data object NavigateToHome : LoginUiEvent()
}