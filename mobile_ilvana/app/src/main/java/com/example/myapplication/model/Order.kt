package com.example.myapplication.model

class Order(
    val id: String,
    val userId: String,
    val products: List<Product>,
    val totalPrice: Double,
    val status: OrderStatus
)