package com.example.letssopt

import androidx.lifecycle.ViewModel

class ContentViewModel: ViewModel() {
    val contents = listOf<Contents>(
        Contents(
            title = "폭싹 속았수다",
            time = "오늘 23:00에 시작",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "폭싹 속았수다",
            time = "오늘 23:00에 시작",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "폭싹 속았수다",
            time = "오늘 23:00에 시작",
            imageRes = R.drawable.image_1
        ),
        Contents(
            title = "이 사랑 통역 되나요?",
            time = "오늘 12:00에 시작",
            imageRes = R.drawable.image_8
        ),
        Contents(
            title = "STRANGER THINGS 5",
            time = "오늘 13:00에 시작",
            imageRes = R.drawable.image_9
        ),
        Contents(
            title = "HALI MARY",
            time = "오늘 10:00에 시작",
            imageRes = R.drawable.image_13
        ),
        Contents(
            title = "왕과 사는 남자",
            time = "오늘 21:13에 시작",
            imageRes = R.drawable.image_16
        ),
        Contents(
            title = "파묘",
            time = "오늘 22:22에 시작",
            imageRes = R.drawable.image_17
        )
    )
}