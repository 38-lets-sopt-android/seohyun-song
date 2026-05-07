package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.ContentItem
import com.example.letssopt.presentation.home.model.WatchaPartyItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _newContents = MutableStateFlow<List<ContentItem>>(emptyList())
    val newContents: StateFlow<List<ContentItem>> = _newContents.asStateFlow()

    private val _watGorithm = MutableStateFlow<List<ContentItem>>(emptyList())
    val watGorithm: StateFlow<List<ContentItem>> = _watGorithm.asStateFlow()

    private val _upComing = MutableStateFlow<List<ContentItem>>(emptyList())
    val upComing: StateFlow<List<ContentItem>> = _upComing.asStateFlow()

    private val _watchaParty = MutableStateFlow<List<WatchaPartyItem>>(emptyList())
    val watchaParty: StateFlow<List<WatchaPartyItem>> = _watchaParty.asStateFlow()

    init {
        _newContents.value = listOf(
            ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
            ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
            ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene)
        )
        _watGorithm.value = listOf(
            ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
            ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
            ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
            ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
        )
        _upComing.value = listOf(
            ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
            ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
            ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
            ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
        )
        _watchaParty.value = listOf(
            WatchaPartyItem(title = "왕과 사는 남자", time = "21:13", imageRes = R.drawable.img_king_man),
            WatchaPartyItem(title = "파묘", time = "22:22", imageRes = R.drawable.img_grave_digging)
        )
    }
}