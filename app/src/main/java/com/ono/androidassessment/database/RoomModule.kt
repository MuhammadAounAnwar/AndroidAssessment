package com.ono.androidassessment.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java, "user_table"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideServersDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

}