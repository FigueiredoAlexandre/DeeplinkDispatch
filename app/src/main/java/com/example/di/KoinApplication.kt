package com.example.di

import android.app.Application
import com.example.deeplinking.di.deepLinkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(deepLinkModule)
        }
    }
}