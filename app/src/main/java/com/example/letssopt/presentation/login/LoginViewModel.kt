package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.local.AuthRepository
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.dto.LoginRequest
import com.example.letssopt.data.remote.dto.LoginResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<LoginUiEvent>()
    val uiEvent: SharedFlow<LoginUiEvent> = _uiEvent.asSharedFlow()

    fun onloginIdChange(loginId: String) {
        _uiState.update { it.copy(loginIdInput = loginId) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(pwInput = password) }
    }

    fun login() {
        val loginId = _uiState.value.loginIdInput
        val pw = _uiState.value.pwInput

        viewModelScope.launch {
            runCatching {
                RetrofitClient.apiService.signIn(
                    LoginRequest(loginId = loginId, password = pw)
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    authRepository.saveLogin(loginId, pw)
                    _uiEvent.emit(LoginUiEvent.ShowToast("로그인에 성공했습니다"))
                    _uiEvent.emit(LoginUiEvent.NavigateToHome)
                } else {
                    val errorMessage = runCatching {
                        val errorJson = response.errorBody()?.string()
                        Json { ignoreUnknownKeys = true }
                            .decodeFromString<LoginResponse>(errorJson ?: "").message
                    }.getOrDefault("이메일 또는 비밀번호가 올바르지 않습니다")
                    _uiEvent.emit(LoginUiEvent.ShowToast(errorMessage))
                }
            }.onFailure { e ->
                _uiEvent.emit(LoginUiEvent.ShowToast(e.message ?: "네트워크 오류가 발생했습니다"))
            }
        }
    }
}