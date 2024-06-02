package com.example.myapplication.model.repositories

import com.example.myapplication.model.Product
import kotlinx.coroutines.flow.Flow
import java.util.Optional

interface BaseRepository<T> {
    suspend fun insert(t: T)

    suspend fun update(t: T)

    suspend fun delete(t: T)

    fun getOneStream(id: Int): Flow<T?>
    abstract fun findAll(): List<T>
    abstract fun save(user: Product): T
    abstract fun deleteById(id: Long): Any
    abstract fun findById(id: Long): Optional<T>
}