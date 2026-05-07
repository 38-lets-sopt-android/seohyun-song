package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.ContentItem
import com.example.letssopt.presentation.home.model.WatchaPartyItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(
            newContents = listOf(
                ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
                ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene),
                ContentItem(title = "크라임씬", imageRes = R.drawable.img_crime_scene)
            ),
            watGorithm = listOf(
                ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
                ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
                ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
                ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
            ),
            upComing = listOf(
                ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
                ContentItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
                ContentItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
                ContentItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate)
            ),
            watchaParty = listOf(
                WatchaPartyItem(title = "왕과 사는 남자", time = "21:13", imageRes = R.drawable.img_king_man),
                WatchaPartyItem(title = "파묘", time = "22:22", imageRes = R.drawable.img_grave_digging)
            )
        ) }
    }
}