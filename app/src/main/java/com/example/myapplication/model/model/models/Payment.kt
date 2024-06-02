package com.example.myapplication.model.model.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Payments")
data class Payment(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "orderId")
    val orderId: Int,

    @ColumnInfo(name = "amount")
    val amount: Double,

    @ColumnInfo(name = "paymentDate")
    val paymentDate: String
)