package com.example.myapplication.model.model.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "userId")
    val userId: Int,

    @ColumnInfo(name = "productId")
    val productId: Int,

    @ColumnInfo(name = "quantity")
    val quantity: Int
)