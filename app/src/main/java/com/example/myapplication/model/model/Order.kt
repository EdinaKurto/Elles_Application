package com.example.myapplication.model.model

import com.example.myapplication.model.model.OrderStatus
import com.example.myapplication.model.model.Product

class Order(
    val id: String,
    val userId: String,
    val products: List<Product>,
    val totalPrice: Double,
    val status: OrderStatus
)