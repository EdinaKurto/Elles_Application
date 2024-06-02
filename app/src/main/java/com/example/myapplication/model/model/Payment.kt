package com.example.myapplication.model.model

class Payment(
    val id: String,
    val orderId: String,
    val amount: Double,
    val paymentMethod: PaymentMethod
)