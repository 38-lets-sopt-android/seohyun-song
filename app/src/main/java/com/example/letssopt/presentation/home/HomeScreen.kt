package com.example.letssopt.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.R
import com.example.letssopt.component.ContentCard
import com.example.letssopt.component.NavigationItem
import com.example.letssopt.component.NewContentCard
import com.example.letssopt.component.WatchaPartyCard
import com.example.letssopt.navigation.Folder
import com.example.letssopt.navigation.HomeTab
import com.example.letssopt.navigation.Purchase
import com.example.letssopt.navigation.Search
import com.example.letssopt.navigation.Webtoon
import com.example.letssopt.presentation.folder.FolderScreen
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.webtoon.WebtoonScreen
import com.example.letssopt.ui.theme.LETSSOPTTheme

data class WatchaPartyItem(
    val title: String,
    val time: String,
    val imageRes: Int
)

data class ContentItem(
    val title: String,
    val imageRes: Int
)

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    newContents: List<ContentItem>,
    watGorithm: List<ContentItem>,
    upComing: List<ContentItem>,
    watchaParty: List<WatchaPartyItem>,
    modifier: Modifier = Modifier
) {
    val tabNavController = rememberNavController()
    val navBackStackEntry by tabNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = modifier,
        topBar = {
            if (currentDestination?.hasRoute<HomeTab>() == true) {
                TopAppBar(
                    title = {Text(text = "")},
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
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(onClick = {}),
                                tint = Color.White,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home_noti),
                                contentDescription = "noti",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(onClick = {}),
                                tint = Color.White,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home_profile),
                                contentDescription = "profile",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(onClick = {}),
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF141414)),
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(72.dp),
                actions = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NavigationItem(R.drawable.ic_bottom_bar_main, "메인",
                            currentDestination?.hasRoute<HomeTab>() == true
                        ) { tabNavController.navigate(HomeTab) { launchSingleTop = true } }

                        NavigationItem(R.drawable.ic_bottom_bar_individual_purchase, "개별 구매",
                            currentDestination?.hasRoute<Purchase>() == true
                        ) { tabNavController.navigate(Purchase) { launchSingleTop = true } }

                        NavigationItem(R.drawable.ic_bottom_bar_webtoon, "웹툰",
                            currentDestination?.hasRoute<Webtoon>() == true
                        ) { tabNavController.navigate(Webtoon) { launchSingleTop = true } }

                        NavigationItem(R.drawable.ic_bottom_bar_search, "찾기",
                            currentDestination?.hasRoute<Search>() == true
                        ) { tabNavController.navigate(Search) { launchSingleTop = true } }

                        NavigationItem(R.drawable.ic_bottom_bar_folder, "보관함",
                            currentDestination?.hasRoute<Folder>() == true
                        ) { tabNavController.navigate(Folder) { launchSingleTop = true } }
                    }
                },
                containerColor = Color(0xFF141414)
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = tabNavController,
            startDestination = HomeTab
        ) {
            composable<HomeTab> { HomeBody(
                innerPadding = innerPadding,
                newContents = newContents,
                watGorithm = watGorithm,
                upComing = upComing,
                watchaParty = watchaParty
            ) }
            composable<Purchase> { PurchaseScreen() }
            composable<Webtoon> { WebtoonScreen() }
            composable<Search> { SearchScreen() }
            composable<Folder> { FolderScreen() }
        }
    }
}

@Composable
fun HomeBody(
    innerPadding: PaddingValues,
    newContents: List<ContentItem>,
    watGorithm: List<ContentItem>,
    upComing: List<ContentItem>,
    watchaParty: List<WatchaPartyItem>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(innerPadding),
    ) {
        item{
            Text(
                text = "방금 막 도착한 신상 콘텐츠",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                color = Color.White,
                modifier = Modifier
                    .padding(start = 19.dp, top = 24.dp)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "예능부터 드라마까지!",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                color = Color(0xFFBABAC1),
                modifier = Modifier
                    .padding(start = 19.dp)
            )
            Spacer(Modifier.height(24.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(newContents) { content ->
                    NewContentCard (
                        title = content.title,
                        imageRes = content.imageRes,
                    )
                }
            }
            Spacer(Modifier.height(26.dp))
        }

        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_section_title),
                    contentDescription = "왓고리즘",
                    modifier = Modifier
                        .width(80.dp)
                        .height(26.dp)
                )
                Spacer(Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "예능부터 드라마까지!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        color = Color(0xFF999999),
                    )
                    Text(
                        text = "더보기",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        color = Color(0xFF999999)
                    )
                }
            }
            Spacer(Modifier.height(6.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
            ) {
                items(watGorithm) { content ->
                    ContentCard (
                        title = content.title,
                        imageRes = content.imageRes
                    )
                }
            }
            Spacer(Modifier.height(26.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "공개 예정 콘텐츠",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    color = Color.White,
                )
                Text(
                    text = "더보기",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    color = Color(0xFF999999)
                )
            }
            Spacer(Modifier.height(8.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
            ) {
                items(upComing) { content ->
                    ContentCard (
                        title = content.title,
                        imageRes = content.imageRes
                    )
                }
            }
            Spacer(Modifier.height(26.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "왓챠 파티",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    color = Color.White,
                )
                Text(
                    text = "더보기",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    color = Color(0xFF999999)
                )
            }
            Spacer(Modifier.height(8.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
            ) {
                items(watchaParty) {
                        content ->
                    WatchaPartyCard (
                        title = content.title,
                        time = content.time,
                        imageRes = content.imageRes
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeRoute()
    }
}