package com.example.koindi.base

import android.app.Application
import com.example.koindi.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(authModule)
        }

    }

}