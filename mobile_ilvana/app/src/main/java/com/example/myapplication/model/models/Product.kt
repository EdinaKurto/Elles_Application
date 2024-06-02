package com.example.myapplication.model.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Double,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String
)