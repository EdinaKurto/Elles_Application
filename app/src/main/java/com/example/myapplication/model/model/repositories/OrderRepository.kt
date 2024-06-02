package com.example.myapplication.model.model.repositories


import com.example.myapplication.model.model.Order
import com.example.myapplication.model.model.Product
import com.example.myapplication.model.model.daos.OrderDao
import com.example.myapplication.model.model.daos.ProductDao
import kotlinx.coroutines.flow.Flow
import java.util.Optional

class OrderRepository(private val orderDao: OrderDao) : BaseRepository<Order> {

    override suspend fun insert(t: Order) {
        orderDao.insertOrder(t)
    }

    override suspend fun update(t: Order) {
        orderDao.updateOrder(t)
    }

    override suspend fun delete(t: Order) {
        orderDao.deleteOrder(t)
    }

    override fun getOneStream(id: Int): Flow<com.example.myapplication.model.model.Order?> {
        return orderDao.getOrderById(id)
    }

    override fun findAll(): List<Order> {
        TODO("Not yet implemented")
    }

    override fun save(user: Product): Order {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long): Any {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<Order> {
        TODO("Not yet implemented")
    }

    suspend fun deleteOrder(order: Order) {
        orderDao.deleteOrder(order)
    }
}