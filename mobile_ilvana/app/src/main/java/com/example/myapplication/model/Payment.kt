package com.example.myapplication.model

class Payment(
    val id: String,
    val orderId: String,
    val amount: Double,
    val paymentMethod: PaymentMethod
)