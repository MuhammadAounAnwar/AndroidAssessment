package com.ono.androidassessment.database

import android.content.Context
import androidx.room.Room

class DatabaseEngine {

    companion object {
        @Volatile
        private var INSTANCE: DatabaseClass? = null
        fun getInstance(context: Context): DatabaseClass {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, DatabaseClass::class.java, "user_table").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}