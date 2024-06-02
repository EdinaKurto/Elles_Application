package com.example.myapplication.model.repositories

import com.example.myapplication.model.Product
import com.example.myapplication.model.User
import com.example.myapplication.model.daos.UserDao
import kotlinx.coroutines.flow.Flow
import java.util.Optional

class UserRepository(private val userDao: UserDao) : BaseRepository<User> {

    @Override
    override suspend fun insert(t: User) {
        userDao.insertUser(t)
    }

    @Override
    override suspend fun update(t: User) {
        userDao.updateUser(t)
    }

    @Override
    override suspend fun delete(t: User) {
        userDao.deleteUser(t)
    }

    @Override
    override fun getOneStream(id: Int): Flow<User?> {
        return userDao.getUserById(id)
    }

    override fun findAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun save(user: Product): User {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long): Any {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<User> {
        TODO("Not yet implemented")
    }
}