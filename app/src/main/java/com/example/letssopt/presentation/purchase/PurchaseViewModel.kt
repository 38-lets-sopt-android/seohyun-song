package com.example.letssopt.presentation.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.R
import com.example.letssopt.data.local.dao.PurchaseDAO
import com.example.letssopt.entity.PurchaseList
import com.example.letssopt.presentation.purchase.model.PurchaseItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PurchaseViewModel(private val dao: PurchaseDAO) : ViewModel() {
    val savedItems: StateFlow<List<PurchaseList>> = dao.getAllPurchaseItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val dummyItems: List<PurchaseItem> = listOf(
        PurchaseItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        PurchaseItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
        PurchaseItem(title = "HALI MARY", imageRes = R.drawable.img_hailmary),
        PurchaseItem(title = "이 사랑 통역 되나요?", imageRes = R.drawable.img_love_traslate),
        PurchaseItem(title = "STRANGER THINGS 5", imageRes = R.drawable.img_stranger_things5),
    )

    fun saveItem(item: PurchaseItem) = viewModelScope.launch {
        dao.insertPurchaseItems(
            PurchaseList(title = item.title, imageRes = item.imageRes)
        )
    }
}