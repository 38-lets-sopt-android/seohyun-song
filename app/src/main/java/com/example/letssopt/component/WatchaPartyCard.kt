package com.example.letssopt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R

@Composable
fun WatchaPartyCard (
    title: String,
    time: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Column(
            modifier = modifier
                .background(Color(0xFF2A2A2A)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .width(196.dp)
                    .aspectRatio(196f/ 139f),
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
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_notisetting),
            contentDescription = "알림 설정",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.TopEnd)
                .padding(top = 7.dp, end = 5.dp)
        )
    }
}