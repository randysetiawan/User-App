package com.randysetiawan.userapp.app

import android.app.Application
import android.util.Log
import com.randysetiawan.userapp.app.module.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UserApp : Application() {
    private lateinit var mInstance: UserApp

    companion object Factory {
        private var mContext: UserApp? = null
        val instance: UserApp by lazy {
            UserApp()
        }
        val context: UserApp by lazy {
            mContext ?: instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mContext = this
        startKoin {
            androidContext(this@UserApp)
            androidLogger(Level.DEBUG)
            Log.d("KOIN", "START")
            modules(
                listOf(databaseModule)
            )
        }
    }
}