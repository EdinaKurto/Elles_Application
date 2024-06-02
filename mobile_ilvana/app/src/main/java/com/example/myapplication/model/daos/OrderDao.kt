package com.example.myapplication.model.daos


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.models.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Insert
    suspend fun insertOrder(order: Order)

    @Update
    suspend fun updateOrder(order: Order)

    @Query("DELETE FROM Orders WHERE id = :orderId")
    suspend fun deleteOrderById(orderId: Int)

    @Query("SELECT * FROM Orders WHERE id = :orderId")
    fun getOrderByIdStream(orderId: Int): Flow<Order?>
    abstract fun deleteOrder(t: Order)
}