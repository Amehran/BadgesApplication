package com.example.achievements

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import leakcanary.AppWatcher


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppWatcher.config = AppWatcher.config.copy(watchFragmentViews = false)  // LeakCanary
    }
}