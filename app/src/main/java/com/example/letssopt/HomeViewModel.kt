package com.example.letssopt

import androidx.lifecycle.ViewModel

class ContentViewModel: ViewModel() {
    val contents = listOf<Contents>(
        Contents(
            title = "폭싹 속았수다",
            time = "23:00",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "폭싹 속았수다",
            time = "23:00",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "폭싹 속았수다",
            time = "23:00",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "이 사랑 통역 되나요?",
            time = "12:00",
            imageRes = R.drawable.image_8
        ),
        Contents(
            title = "STRANGER THINGS 5",
            time = "13:00",
            imageRes = R.drawable.image_9
        ),
        Contents(
            title = "HALI MARY",
            time = "10:00",
            imageRes = R.drawable.image_13
        ),
        Contents(
            title = "이 사랑 통역 되나요?",
            time = "12:00",
            imageRes = R.drawable.image_8
        ),
        Contents(
            title = "왕과 사는 남자",
            time = "21:13",
            imageRes = R.drawable.image_16
        ),
        Contents(
            title = "파묘",
            time = "22:22",
            imageRes = R.drawable.image_17
        )
    )
}