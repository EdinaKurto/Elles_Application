package com.example.myapplication.model.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM Products WHERE id = :id")
    fun getProductById(id: Int): Flow<Product?>

    @Query("SELECT * FROM Products")
    fun getAllProducts(): Flow<List<Product>>
}