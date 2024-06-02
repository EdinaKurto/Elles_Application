package com.example.myapplication.model.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): Flow<User?>

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: String): User?

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteUserById(id: String)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User

    @Update
    suspend fun updateUser(user: User)

    @Insert
    suspend fun insertUser(user: User)
}

