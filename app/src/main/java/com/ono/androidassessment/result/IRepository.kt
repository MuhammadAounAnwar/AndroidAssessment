package com.ono.androidassessment.result

import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.network.Apis
import com.ono.androidassessment.network.RetrofitHelper

interface IRepository {
    suspend fun getUserAge(userName: String): UserAgeModel
}

private const val TAG = "RepositoryImpl"

class RepositoryImpl : IRepository {
    override suspend fun getUserAge(userName: String): UserAgeModel {
        val instance = RetrofitHelper.getInstance().create(Apis::class.java)
        val result = instance.getUserAge(userName)
        return UserAgeModel(0, result.body()?.name, result.body()?.age, result.body()?.count)
    }
}