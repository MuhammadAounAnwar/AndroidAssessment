package com.ono.androidassessment.history

import androidx.lifecycle.LiveData
import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.database.UserDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

interface IHistoryRepo {
    suspend fun getAllUserDetails(): LiveData<List<UserAgeModel>>
}

class HistoryRepoImpl @Inject constructor(private val userDao: UserDao) : IHistoryRepo {
    var result: List<UserAgeModel> = arrayListOf()
    override suspend fun getAllUserDetails(): LiveData<List<UserAgeModel>> {
        return userDao.getAllUsersDetails()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideRepo(historyRepoImpl: HistoryRepoImpl): IHistoryRepo
}