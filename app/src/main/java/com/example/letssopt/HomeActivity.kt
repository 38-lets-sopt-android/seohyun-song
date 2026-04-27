package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.ui.theme.LETSSOPTTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                HomeScreen()
            }
        }
    }
}

data class Contents(
    val title: String,
    val time: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ContentViewModel = viewModel()
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
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
                            painter = painterResource(id = R.drawable.ic_watch),
                            contentDescription = "watch",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable(onClick = {}),
                            tint = Color.White,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_noti),
                            contentDescription = "noti",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable(onClick = {}),
                            tint = Color.White,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
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
                        NavigationItem(R.drawable.ic_main, "메인", selectedTab == 0) { selectedTab = 0 }
                        NavigationItem(R.drawable.ic_individual_purchase, "개별 구매", selectedTab == 1) { selectedTab = 1 }
                        NavigationItem(R.drawable.ic_webtoon, "웹툰", selectedTab == 2) { selectedTab = 2 }
                        NavigationItem(R.drawable.ic_search, "찾기", selectedTab == 3) { selectedTab = 3 }
                        NavigationItem(R.drawable.ic_folder, "보관함", selectedTab == 4) { selectedTab = 4 }
                    }
                },
                containerColor = Color(0xFF141414)
            )
        }
    ) { innerPadding ->
        when (selectedTab) {
            0 -> HomeContent(innerPadding, viewModel)
            1 -> PurchaseScreen(innerPadding)
            2 -> WebtoonScreen(innerPadding)
            3 -> SearchScreen(innerPadding)
            4 -> FolderScreen(innerPadding)
        }
    }
}

@Composable
fun HomeContent(innerPadding: PaddingValues, viewModel: ContentViewModel) {
    val scrollState = rememberScrollState()
    val newContentsDisplay = viewModel.contents.take(3)
    val watGorithm = viewModel.contents.drop(3).take(4)
    val watchaParty = viewModel.contents.drop(7).take(2)

    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(innerPadding),
    ) {
        Text(
            text = "방금 막 도착한 신상 콘텐츠",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
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
                .align(Alignment.Start)
                .padding(start = 19.dp)
        )
        Spacer(Modifier.height(24.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(newContentsDisplay) { content ->
                NewContentItem(
                    title = content.title,
                    time = content.time,
                    imageRes = content.imageRes
                )
            }
        }
        Spacer(Modifier.height(26.dp))
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
                ContentItem (
                    title = content.title,
                    time = content.time,
                    imageRes = content.imageRes
                )
            }
        }
        Spacer(Modifier.height(26.dp))
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
            items(watGorithm) { content ->
                ContentItem (
                    title = content.title,
                    time = content.time,
                    imageRes = content.imageRes
                )
            }
        }
        Spacer(Modifier.height(26.dp))
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
                WatchaPartyItem (
                    title = content.title,
                    time = content.time,
                    imageRes = content.imageRes
                )
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun NewContentItem(
    title: String,
    time: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = title,
        modifier = Modifier
            .width(280.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(10.dp)),
    )
}

@Composable
fun ContentItem(
    title: String,
    time: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = title,
        modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp)),
    )
}

@Composable
fun WatchaPartyItem (
    title: String,
    time: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Column(
            modifier = Modifier
                .background(Color(0xFF2A2A2A)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .width(196.dp)
                    .height(139.dp),
            )
            Text(
                text = "오늘 ${time}에 시작",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                color = Color(0xFFE8003C),
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = "# $title",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 7.dp, end = 5.dp)
                .size(35.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_noti_black),
                contentDescription = "알림",
                modifier = Modifier.size(18.dp),
            )
        }
    }
}

@Composable
fun NavigationItem(icon: Int, text: String, isSelected: Boolean, onClick: () -> Unit) {
    val iconColor = if (isSelected) Color.White else Color(0xFF333333)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(width = 48.dp, height = 50.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(24.dp),
            tint = iconColor
        )
        Spacer(Modifier.height(7.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            color = iconColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeScreen()
    }
}