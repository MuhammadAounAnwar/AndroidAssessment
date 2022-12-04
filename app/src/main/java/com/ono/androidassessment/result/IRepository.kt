package com.ono.androidassessment.result

import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.database.UserDao
import com.ono.androidassessment.network.Apis
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

interface IRepository {
    suspend fun getUserAge(userName: String): UserAgeModel
}

class RepositoryImpl @Inject constructor(private val apis: Apis, private val userDao: UserDao) : IRepository {
    override suspend fun getUserAge(userName: String): UserAgeModel {
        val result = apis.getUserAge(userName)
        val userAgeModel = UserAgeModel(0, result.body()?.name, result.body()?.age, result.body()?.count)
        CoroutineScope(Dispatchers.Default).async {
            userDao.insertNewDetail(userAgeModel)
        }
        return userAgeModel
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideRepo(repositoryImpl: RepositoryImpl): IRepository
}
