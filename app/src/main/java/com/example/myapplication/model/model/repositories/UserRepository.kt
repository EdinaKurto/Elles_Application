package com.example.myapplication.model.model.repositories

import com.example.myapplication.model.model.User
import com.example.myapplication.model.model.daos.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    fun getUserByEmail(email: String): Flow<User?> {
        return userDao.getUserByEmail(email)
    }

    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun getUserById(id: String): User? {
        return userDao.getUserById(id)
    }


    suspend fun deleteUserById(id: String) {
        userDao.deleteUserById(id)
    }

    suspend fun getUser(): User {
        return userDao.getUser()
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}
