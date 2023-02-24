package com.randysetiawan.userapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var idUser: Int = 0,
    @ColumnInfo(name = "username") var username: String?,
    @ColumnInfo(name = "email") var email : String?,
    @ColumnInfo(name = "firstName") var firstName: String?,
    @ColumnInfo(name = "lastName") var lastName: String?,
    @ColumnInfo(name = "age") var age: Int = 0,
    @ColumnInfo(name = "password") var password: String?
)
