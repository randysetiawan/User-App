package com.randysetiawan.userapp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.randysetiawan.userapp.model.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user")
    fun listAllUser(): List<UserEntity>

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun findUserByUsernamePassword(username: String, password: String): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: UserEntity)

}