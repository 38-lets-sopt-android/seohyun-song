package com.example.letssopt.presentation.purchase.model

import androidx.annotation.DrawableRes

data class PurchaseItem(
    val title: String,
    @DrawableRes
    val imageRes: Int
)