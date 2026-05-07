package com.example.letssopt.presentation.login

data class LoginUiState(
    val emailInput: String = "",
    val pwInput: String = "",
)

sealed class LoginUiEvent {
    data class ShowToast(val message: String) : LoginUiEvent()
    data object NavigateToHome : LoginUiEvent()
}