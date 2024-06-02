package com.example.myapplication.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Order
import com.example.myapplication.model.Product
import com.example.myapplication.model.daos.OrderDao
import com.example.myapplication.model.daos.ProductDao

@Database(entities = [Order::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}