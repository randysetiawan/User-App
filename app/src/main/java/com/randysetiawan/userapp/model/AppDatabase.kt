package com.randysetiawan.userapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.randysetiawan.userapp.model.dao.UserDao
import com.randysetiawan.userapp.model.entity.UserEntity

@Database(
    entities = [
                UserEntity::class
               ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}