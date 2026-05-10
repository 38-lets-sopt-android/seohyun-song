package com.example.letssopt.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.component.NavigationItem
import com.example.letssopt.navigation.Folder
import com.example.letssopt.navigation.Home
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Webtoon
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

    Scaffold(
        modifier = modifier,
        topBar = {
            if (currentDestination?.hasRoute<Home>() == true) {
                TopAppBar(
                    title = { Text(text = "") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(70.dp),
                    actions = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(end = 20.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home_watch),
                                contentDescription = "watch",
                                modifier = Modifier.size(24.dp).clickable(onClick = {}),
                                tint = Color.White,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home_noti),
                                contentDescription = "noti",
                                modifier = Modifier.size(24.dp).clickable(onClick = {}),
                                tint = Color.White,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home_profile),
                                contentDescription = "profile",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(onClick = {navigateToProfile()}),
                                tint = Color.White,
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF141414)),
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth().heightIn(72.dp),
                actions = {
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
                },
                containerColor = Color(0xFF141414)
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = tabNavController,
            startDestination = Home
        ) {
            composable<Home> { HomeRoute(innerPadding = innerPadding) }
            composable<Purchase> { PurchaseScreen() }
            composable<Webtoon> { WebtoonScreen() }
            composable<Search> { SearchScreen() }
            composable<Folder> { FolderScreen() }
        }
    }
}