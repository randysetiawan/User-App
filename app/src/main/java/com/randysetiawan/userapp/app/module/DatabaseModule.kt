package com.randysetiawan.userapp.app.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.randysetiawan.userapp.model.AppDatabase
import com.randysetiawan.userapp.model.dao.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun test() {
        Log.d("ROOM", "DBMODULE RUN")
    }
    fun provideDatabase(application: Application): AppDatabase {
        Log.d("ROOM", "PROVIDE_DATABASE")
        return Room.databaseBuilder(application, AppDatabase::class.java, "user.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    single { test()}
    single { provideDatabase(androidApplication()) }
    single { provideUserDao(get()) }

}