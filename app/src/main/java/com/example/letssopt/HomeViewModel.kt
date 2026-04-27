package com.example.letssopt

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val newContents = listOf(
        ContentItem(title = "폭싹 속았수다", imageRes = R.drawable.image_1),
        ContentItem(title = "폭싹 속았수다", imageRes = R.drawable.image_1),
        ContentItem(title = "폭싹 속았수다", imageRes = R.drawable.image_1)
    )

    val watGorithm = listOf(
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.image_8),
        ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.image_9),
        ContentItem(title = "HALI MARY", imageRes = R.drawable.image_13),
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.image_8)
    )

    val upComing = listOf(
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.image_8),
        ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.image_9),
        ContentItem(title = "HALI MARY", imageRes = R.drawable.image_13),
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.image_8)
    )

    val watchaParty = listOf(
        WatchaPartyItem(title = "왕과 사는 남자", time = "21:13", imageRes = R.drawable.image_16),
        WatchaPartyItem(title = "파묘", time = "22:22", imageRes = R.drawable.image_17)
    )
}