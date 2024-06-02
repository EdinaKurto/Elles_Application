package com.example.myapplication.services

import com.example.myapplication.model.model.User
import com.example.myapplication.model.model.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import java.util.*

class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): Flow<List<User>> = userRepository.getAllUsers()

    suspend fun getUserById(id: String): User? = userRepository.getUserById(id)

    suspend fun deleteUserById(id: String) = userRepository.deleteUserById(id)
}
