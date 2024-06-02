package com.example.myapplication.model.repositories

import com.example.myapplication.model.Product
import com.example.myapplication.model.daos.ProductDao
import kotlinx.coroutines.flow.Flow
import java.util.Optional

class ProductRepository(private val productDao: ProductDao) : BaseRepository<com.example.myapplication.model.Product> {

    override suspend fun insert(t: com.example.myapplication.model.Product) {
        productDao.insertProduct(t)
    }

    override suspend fun update(t: com.example.myapplication.model.Product) {
        productDao.updateProduct(t)
    }

    override suspend fun delete(t: com.example.myapplication.model.Product) {
        productDao.deleteProduct(t)
    }

    override fun getOneStream(id: Int): Flow<com.example.myapplication.model.Product?> {
        return productDao.getProductById(id)
    }

    override fun findAll(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun save(user: Product): Product {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long): Any {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<Product> {
        TODO("Not yet implemented")
    }

    fun getAllProducts(): Flow<List<com.example.myapplication.model.Product>> {
        return productDao.getAllProducts()
    }
}