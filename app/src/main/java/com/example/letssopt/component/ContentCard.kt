package com.example.letssopt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ContentCard(
    title: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = title,
        modifier = modifier
            .width(100.dp)
            .aspectRatio(100f / 150f)
            .clip(RoundedCornerShape(10.dp)),
    )
}