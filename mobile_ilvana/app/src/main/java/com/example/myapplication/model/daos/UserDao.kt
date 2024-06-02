package com.example.myapplication.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("DELETE FROM users")
    fun deleteAllUsers()
    abstract fun updateUser(t: User)
    abstract fun deleteUser(t: User)
    abstract fun getUserById(id: Int): Flow<User?>
}