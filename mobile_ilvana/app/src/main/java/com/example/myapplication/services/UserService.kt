package com.example.myapplication.services

import com.example.myapplication.model.User
import com.example.myapplication.model.repositories.UserRepository
import java.util.Optional


class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()
    fun getUserById(id: Long): Optional<User> = userRepository.findById(id)
   // fun saveUser(user: User): User = userRepository.save(user)
    fun deleteUser(id: Long) = userRepository.deleteById(id)
}