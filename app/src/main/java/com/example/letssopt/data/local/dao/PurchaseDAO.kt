package com.example.letssopt.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.letssopt.entity.PurchaseList
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDAO {
    @Insert
    suspend fun insertPurchaseItems(item: PurchaseList)

    @Query("SELECT * FROM purchase")
    fun getAllPurchaseItems(): Flow<List<PurchaseList>>
}