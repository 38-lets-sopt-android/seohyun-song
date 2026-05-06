package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.local.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<LoginUiEvent>()
    val uiEvent: SharedFlow<LoginUiEvent> = _uiEvent.asSharedFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(emailInput = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(pwInput = password) }
    }

    fun login(registeredEmail: String, registeredPw: String) {
        val email = _uiState.value.emailInput
        val pw = _uiState.value.pwInput

        viewModelScope.launch {
            when {
                registeredEmail.isEmpty() || registeredPw.isEmpty() -> {
                    _uiEvent.emit(LoginUiEvent.ShowToast("먼저 회원가입을 진행해 주세요"))
                }
                email != registeredEmail || pw != registeredPw -> {
                    _uiEvent.emit(LoginUiEvent.ShowToast("이메일 또는 비밀번호가 올바르지 않습니다"))
                }
                else -> {
                    authRepository.saveLogin(email, pw)
                    _uiEvent.emit(LoginUiEvent.ShowToast("로그인에 성공했습니다"))
                    _uiEvent.emit(LoginUiEvent.NavigateToHome)
                }
            }
        }
    }
}