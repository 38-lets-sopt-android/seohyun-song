package com.example.letssopt.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.component.NavigationItem
import com.example.letssopt.core.Folder
import com.example.letssopt.core.Home
import com.example.letssopt.core.Purchase
import com.example.letssopt.core.Search
import com.example.letssopt.core.Webtoon
import com.example.letssopt.presentation.folder.FolderScreen
import com.example.letssopt.presentation.home.HomeRoute
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.webtoon.WebtoonScreen

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tabNavController = rememberNavController()
    val navBackStackEntry by tabNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box(modifier = modifier.fillMaxSize()) {
        NavHost(
            navController = tabNavController,
            startDestination = Home,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<Home> { HomeRoute(navigateToProfile = navigateToProfile) }
            composable<Purchase> { PurchaseScreen() }
            composable<Webtoon> { WebtoonScreen() }
            composable<Search> { SearchScreen() }
            composable<Folder> { FolderScreen() }
        }

        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(72.dp)
                .align(Alignment.BottomCenter),
            containerColor = Color(0xFF141414)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                NavigationItem(R.drawable.ic_bottom_bar_main, "메인",
                    currentDestination?.hasRoute<Home>() == true
                ) {
                    tabNavController.navigate(Home) {
                        popUpTo<Home> {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                NavigationItem(R.drawable.ic_bottom_bar_individual_purchase, "개별 구매",
                    currentDestination?.hasRoute<Purchase>() == true
                ) {
                    tabNavController.navigate(Purchase) {
                        popUpTo<Home> {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                NavigationItem(R.drawable.ic_bottom_bar_webtoon, "웹툰",
                    currentDestination?.hasRoute<Webtoon>() == true
                ) {
                    tabNavController.navigate(Webtoon) {
                        popUpTo<Home> {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                NavigationItem(R.drawable.ic_bottom_bar_search, "찾기",
                    currentDestination?.hasRoute<Search>() == true
                ) {
                    tabNavController.navigate(Search) {
                        popUpTo<Home> {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                NavigationItem(R.drawable.ic_bottom_bar_folder, "보관함",
                    currentDestination?.hasRoute<Folder>() == true
                ) {
                    tabNavController.navigate(Folder) {
                        popUpTo<Home> {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }


        }
    }
}