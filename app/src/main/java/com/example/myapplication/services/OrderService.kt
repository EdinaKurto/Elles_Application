package com.example.myapplication.services

import com.example.myapplication.model.model.Order
import com.example.myapplication.model.model.repositories.OrderRepository
import java.util.Optional

class OrderService(private val orderRepository: OrderRepository) {
    fun getAllOrders(): List<Order> = orderRepository.findAll()
    fun getOrderById(id: Long): Optional<Order> = orderRepository.findById(id)
    // fun saveOrder(order: Order): com.example.myapplication.model.models.Order = orderRepository.save(order)
    fun deleteOrder(id: Long) = orderRepository.deleteById(id)
}