package com.ono.androidassessment

import android.app.Application
import com.ono.androidassessment.database.DatabaseEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.Default).launch {
//            DatabaseEngine.initDatabase(this@App)
        }
    }
}