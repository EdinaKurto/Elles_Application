package com.example.myapplication.model.daos

import androidx.contentpager.content.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query as RoomQuery
import com.example.myapplication.model.Admin

@Dao
interface AdminDao {
    @RoomQuery("SELECT * FROM Admin")
    fun getAllAdmins(): List<Admin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdmin(admin: Admin)

    @RoomQuery("DELETE FROM Admin")
    fun deleteAllAdmins()
}