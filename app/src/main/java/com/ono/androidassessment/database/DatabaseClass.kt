package com.ono.androidassessment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ono.androidassessment.UserAgeModel


@Database(entities = [UserAgeModel::class], version = 1)
abstract class DatabaseClass : RoomDatabase() {
    abstract fun userDao(): UserDao
}
