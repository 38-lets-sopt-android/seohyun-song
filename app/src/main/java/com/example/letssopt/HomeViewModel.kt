package com.example.letssopt

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val newContents = listOf(
        ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
        ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
        ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene)
    )

    val watGorithm = listOf(
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
        ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
    )

    val upComing = listOf(
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
        ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
        ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
    )

    val watchaParty = listOf(
        WatchaPartyItem(title = "왕과 사는 남자", time = "21:13", imageRes = R.drawable.img_king_man),
        WatchaPartyItem(title = "파묘", time = "22:22", imageRes = R.drawable.img_grave_digging)
    )
}