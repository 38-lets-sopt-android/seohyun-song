package com.example.letssopt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.letssopt.HomeViewModel
import com.example.letssopt.activity.FolderScreen
import com.example.letssopt.activity.HomeScreen
import com.example.letssopt.activity.LoginScreen
import com.example.letssopt.activity.PurchaseScreen
import com.example.letssopt.activity.SearchScreen
import com.example.letssopt.activity.SignUpScreen
import com.example.letssopt.activity.WebtoonScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Login()
    ) {
        composable<Login> { backStackEntry ->
            val login: Login = backStackEntry.toRoute()

            LoginScreen(
                registeredEmail = login.email,
                registeredPw = login.password,
                navigateToSignUp = {
                    navController.navigate(SignUp)
                },
                navigateToHome = {
                    navController.navigate(Home) {
                        popUpTo<Login> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<SignUp> {
            SignUpScreen(
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
            val viewModel: HomeViewModel = viewModel()

            HomeScreen(
                viewModel = viewModel,
                navigateToPurchase = {
                    navController.navigate(Purchase)
                },
                navigateToWebtoon = {
                    navController.navigate(Webtoon)
                },
                navigateToSearch = {
                    navController.navigate(Search)
                },
                navigateToFolder = {
                    navController.navigate(Folder)
                }
            )
        }
        composable<Purchase> {
            PurchaseScreen()
        }
        composable<Webtoon> {
            WebtoonScreen()
        }
        composable<Search> {
            SearchScreen()
        }
        composable<Folder> {
            FolderScreen()
        }
    }
}