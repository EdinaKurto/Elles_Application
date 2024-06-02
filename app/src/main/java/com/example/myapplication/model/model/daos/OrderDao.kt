package com.example.myapplication.model.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.model.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert
    suspend fun insertOrder(order: Order)

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)

    @Query("SELECT * FROM Orders WHERE id = :id")
    fun getOrderById(id: Int): Flow<Order?>

    @Query("SELECT * FROM Orders")
    fun getAllOrders(): Flow<List<Order>>
}