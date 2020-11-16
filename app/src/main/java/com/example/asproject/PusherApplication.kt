package com.example.asproject

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {
    override fun onCreate() {
        Timber.i("onCreate")
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}