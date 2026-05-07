package com.example.letssopt.presentation.signup

data class SignUpUiState(
    val emailInput: String = "",
    val pwInput: String = "",
    val pwConfirm: String =""
) {
    val isButtonEnabled: Boolean
        get() = emailInput.isNotBlank() && pwInput.isNotBlank() && pwConfirm.isNotBlank()
}

sealed class SignUpUiEvent {
    data class ShowToast(val message: String) : SignUpUiEvent()
    data class NavigateToLogin(val email: String, val password: String) : SignUpUiEvent()
}