package com.example.myapplication.services

import com.example.myapplication.model.Product
import com.example.myapplication.model.repositories.ProductRepository
import java.util.Optional

class ProductService(private val productRepository: ProductRepository) {
    fun getAllProducts(): List<Product> = productRepository.findAll()
    fun getProductById(id: Long): Optional<Product> = productRepository.findById(id)
    fun saveProduct(product: Product): Product = productRepository.save(product)
    fun deleteProduct(id: Long) = productRepository.deleteById(id)
}