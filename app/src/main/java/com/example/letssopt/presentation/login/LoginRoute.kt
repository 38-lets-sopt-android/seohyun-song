package com.example.letssopt.presentation.login

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.data.local.AuthRepository

@Composable
fun LoginRoute(
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val context = LocalContext.current
    val viewModel: LoginViewModel = viewModel {
        LoginViewModel(AuthRepository(context.applicationContext))
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is LoginUiEvent.ShowToast ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                is LoginUiEvent.NavigateToHome -> navigateToHome()
            }
        }
    }

    LoginScreen(
        uiState = uiState,
        onloginIdChange = viewModel::onloginIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = viewModel::login,
        navigateToSignUp = navigateToSignUp
    )
}