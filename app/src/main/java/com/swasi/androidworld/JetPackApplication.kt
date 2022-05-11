package com.swasi.androidworld

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Created by Sibaprasad Mohanty on 04/05/2022.
 * siba.x.prasad@gmail.com
 */

@HiltAndroidApp
class JetPackApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}