package com.example.letssopt.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.component.UserInfoItem

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(horizontal = 20.dp, vertical = 70.dp)
    ) {
        Text(
            text = "프로필",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 7.dp),
        )

        Spacer(modifier = Modifier.height(68.dp))

        UserInfoItem(
            label = "아이디",
            value = uiState.loginId
        )

        UserInfoItem(
            label = "이름",
            value = uiState.name
        )

        UserInfoItem(
            label = "이메일",
            value = uiState.email
        )

        UserInfoItem(
            label = "나이",
            value = uiState.age.toString()
        )

        UserInfoItem(
            label = "파트",
            value = uiState.part
        )
    }
}