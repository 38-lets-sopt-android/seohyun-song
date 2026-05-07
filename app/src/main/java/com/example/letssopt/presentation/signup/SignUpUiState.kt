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
        // TODO: 조건 추가 필요!
        get() = emailInput.isNotBlank() && pwInput.isNotBlank() && pwConfirm.isNotBlank()
}

sealed class SignUpUiEvent {
    data class ShowToast(val message: String) : SignUpUiEvent()
    data class NavigateToLogin(val email: String, val password: String) : SignUpUiEvent()
}