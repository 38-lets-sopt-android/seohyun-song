package com.example.letssopt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.letssopt.data.local.dao.PurchaseDAO
import com.example.letssopt.entity.PurchaseList

@Database(entities = [PurchaseList::class], version = 1)
abstract class PurchaseDatabase : RoomDatabase() {
    abstract fun PurchaseDAO(): PurchaseDAO

    companion object {
        @Volatile
        private var INSTANCE: PurchaseDatabase? = null

        fun getDatabase(context: Context): PurchaseDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    PurchaseDatabase::class.java,
                    "app_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}