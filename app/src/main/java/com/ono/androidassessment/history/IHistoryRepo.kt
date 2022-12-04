package com.ono.androidassessment.history

import android.content.Context
import androidx.lifecycle.LiveData
import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.database.DatabaseEngine

interface IHistoryRepo {
    suspend fun getAllUserDetails(): LiveData<List<UserAgeModel>>
}

class HistoryRepoImpl(val context: Context) : IHistoryRepo {

    var result: List<UserAgeModel> = arrayListOf()
    override suspend fun getAllUserDetails(): LiveData<List<UserAgeModel>> {
        return DatabaseEngine.getInstance(context).userDao().getAllUsersDetails()

    }

//    override suspend fun getAllUserDetails(): List<UserAgeModel> {
//        val res = CoroutineScope(Dispatchers.Default).async {
//            result = DatabaseEngine.getInstance(context).userDao().getAllUsersDetails()
//        }
//        res.await()
//        return result
//    }

}