package com.example.letssopt.presentation.main

import androidx.lifecycle.ViewModel
import com.example.letssopt.data.local.AuthRepository

class AppViewModel(private val authRepository: AuthRepository) : ViewModel() {
    fun isAutoLoginAvailable(): Boolean = authRepository.isAutoLoginAvailable()
}