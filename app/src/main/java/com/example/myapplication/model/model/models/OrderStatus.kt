package com.example.myapplication.model.model.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "OrderStatus")
data class OrderStatus(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String
)