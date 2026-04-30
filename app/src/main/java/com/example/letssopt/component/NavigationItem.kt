package com.example.letssopt.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R

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
