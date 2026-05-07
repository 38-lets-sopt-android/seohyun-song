package com.example.letssopt.presentation.signup

data class SignUpUiState(
    val loginIdInput: String = "",
    val pwInput: String = "",
    val pwConfirm: String ="",
    val nameInput: String = "",
    val emailInput: String = "",
    val ageInput: String = "",
    val partInput: String = ""
) {
    val isButtonEnabled: Boolean
        get() = loginIdInput.isNotBlank() && pwInput.isNotBlank() && pwConfirm.isNotBlank() && nameInput.isNotBlank() && emailInput.isNotBlank() && ageInput.isNotBlank() && partInput.isNotBlank()
}

sealed class SignUpUiEvent {
    data class ShowToast(val message: String) : SignUpUiEvent()
    data class NavigateToLogin(val email: String, val password: String) : SignUpUiEvent()
}