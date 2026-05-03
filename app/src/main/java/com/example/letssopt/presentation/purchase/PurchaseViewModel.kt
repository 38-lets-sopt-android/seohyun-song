package com.example.letssopt.presentation.purchase

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.R
import com.example.letssopt.dao.PurchaseDAO
import com.example.letssopt.entity.PurchaseList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class PurchaseViewModel(private val dao: PurchaseDAO) : ViewModel() {
    val savedItems: StateFlow<List<PurchaseList>> = dao.getAllPurchaseItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val dummyItems: List<PurchaseItem> = listOf(
        PurchaseItem(id = 1, title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        PurchaseItem(id = 2, title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
        PurchaseItem(id = 3, title = "HALI MARY", imageRes = R.drawable.img_hailmary),
        PurchaseItem(id = 4, title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        PurchaseItem(id = 5, title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
    )

    fun saveItem(item: PurchaseItem) = viewModelScope.launch {
        dao.insertPurchaseItems(
            PurchaseList(title = item.title, imageRes = item.imageRes)
        )
    }
}

data class PurchaseItem(
    val id: Long,
    val title: String,
    @DrawableRes
    val imageRes: Int
)