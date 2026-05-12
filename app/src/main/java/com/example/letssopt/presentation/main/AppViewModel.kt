package com.example.letssopt.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.local.AuthRepository
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.dto.LoginRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _userId = MutableStateFlow(authRepository.getUserId())
    val userId: StateFlow<Int> = _userId.asStateFlow()

    fun isAutoLoginAvailable(): Boolean = authRepository.isAutoLoginAvailable()

    init {
        if (authRepository.isAutoLoginAvailable() && authRepository.getUserId() == -1) {
            viewModelScope.launch {
                val (loginId, password) = authRepository.getCredentials()
                runCatching {
                    RetrofitClient.authService.signIn(LoginRequest(loginId, password))
                }.onSuccess { response ->
                    response.body()?.data?.userId?.let { id ->
                        authRepository.saveUserId(id)
                        _userId.value = id
                    }
                }
            }
        }
    }
}