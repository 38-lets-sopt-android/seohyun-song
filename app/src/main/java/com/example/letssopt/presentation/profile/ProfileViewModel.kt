package com.example.letssopt.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<ProfileUiEvent>()
    val uiEvent: SharedFlow<ProfileUiEvent> = _uiEvent.asSharedFlow()

    fun getUser(userId: Int) {
        viewModelScope.launch {
            runCatching {
                RetrofitClient.userService.getUser(userId)
            }
                .onSuccess { response ->
                    response.data?.let { data ->
                        _uiState.update {
                            it.copy(
                                id = data.id,
                                loginId = data.loginId,
                                name = data.name,
                                email = data.email,
                                age = data.age,
                                part = data.part
                            )
                        }
                    }
                }
                .onFailure { e ->
                    _uiEvent.emit(ProfileUiEvent.ShowToast(e.message ?: "네트워크 오류가 발생했습니다"))
                }
        }
    }

}