package com.example.letssopt.presentation.signup

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.dto.SignUpRequest
import com.example.letssopt.data.remote.dto.SignUpResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<SignUpUiEvent>()
    val uiEvent: SharedFlow<SignUpUiEvent> = _uiEvent.asSharedFlow()

    fun onLoginIdChange(login: String) {
        _uiState.update { it.copy(loginIdInput = login) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(pwInput = password) }
    }

    fun onPasswordConfirmChange(passwordConfirm: String) {
        _uiState.update { it.copy(pwConfirm = passwordConfirm) }
    }

    fun onNameChange(name: String) {
        _uiState.update { it.copy(nameInput = name) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(emailInput = email) }
    }

    fun onAgeChange(age: String) {
        _uiState.update { it.copy(ageInput = age) }
    }

    fun onPartChange(part: String) {
        _uiState.update { it.copy(partInput = part) }
    }

    fun signUp() {
        val loginId = _uiState.value.loginIdInput
        val pw = _uiState.value.pwInput
        val pwConfirm = _uiState.value.pwConfirm
        val name = _uiState.value.nameInput
        val email = _uiState.value.emailInput
        val age = _uiState.value.ageInput.toInt()
        val part = _uiState.value.partInput

        viewModelScope.launch {
            when {
                !EMAIL_ADDRESS.matcher(email).matches() -> {
                    _uiEvent.emit(SignUpUiEvent.ShowToast("이메일 형식이 올바르지 않습니다"))
                }

                pw.length !in 8..12 -> {
                    _uiEvent.emit(SignUpUiEvent.ShowToast("비밀번호는 8자 이상 12자 이하로 입력해 주세요"))
                }

                pw != pwConfirm -> {
                    _uiEvent.emit(SignUpUiEvent.ShowToast("비밀번호가 일치하지 않습니다"))
                }

                else -> {
                    runCatching {
                        RetrofitClient.apiService.signUp(
                            SignUpRequest(loginId, pw, name, email, age, part)
                        )
                    }.onSuccess { response ->
                        if (response.isSuccessful) {
                            _uiEvent.emit(SignUpUiEvent.ShowToast("회원가입에 성공했습니다"))
                            _uiEvent.emit(SignUpUiEvent.NavigateToLogin(email, pw))
                        } else {
                            val errorMessage = runCatching {
                                val errorJson = response.errorBody()?.string()
                                Json.decodeFromString<SignUpResponse>(errorJson ?: "").message
                            }.getOrDefault("회원가입에 실패했습니다")
                            _uiEvent.emit(SignUpUiEvent.ShowToast(errorMessage))
                        }
                    }.onFailure { e ->
                        _uiEvent.emit(SignUpUiEvent.ShowToast(e.message ?: "네트워크 오류가 발생했습니다"))
                    }
                }
            }
        }
    }
}