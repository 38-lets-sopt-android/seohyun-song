package com.example.letssopt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.letssopt.data.local.AuthRepository
import com.example.letssopt.presentation.home.HomeRoute
import com.example.letssopt.presentation.login.LoginRoute
import com.example.letssopt.presentation.main.AppViewModel
import com.example.letssopt.presentation.signup.SignUpRoute

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    val context = LocalContext.current
    val appViewModel: AppViewModel = viewModel{
        AppViewModel(AuthRepository(context.applicationContext))
    }
    val startDestination = if (appViewModel.isAutoLoginAvailable()) {
        Home
    } else {
        Login
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Login> { backStackEntry ->
            val login: Login = backStackEntry.toRoute()

            LoginRoute(
                registeredEmail = login.email,
                registeredPw = login.password,
                navigateToSignUp = { navController.navigate(SignUp) },
                navigateToHome = {
                    navController.navigate(Home) {
                        popUpTo<Login> { inclusive = true }
                    }
                }
            )
        }
        composable<SignUp> {
            SignUpRoute(
                navigateToLogin = { email, password ->
                    navController.navigate(
                        Login(email = email, password = password)
                    ) {
                        popUpTo<SignUp> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Home> {
            HomeRoute()
        }
    }
}