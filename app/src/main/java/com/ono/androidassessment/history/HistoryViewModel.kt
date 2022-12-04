package com.ono.androidassessment.history

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class HistoryViewModel(savedStateHandle: SavedStateHandle, private val context: Context) : ViewModel() {

    private val iHistoryRepo by lazy {
        HistoryRepoImpl(context)
    }
//    val history = flow {
//        emit(iHistoryRepo.getAllUserDetails())
//    }.asLiveData()


//    val history = flow {
//        emit(DatabaseEngine.getInstance(context).userDao().getAllUsersDetails())
//    }.asLiveData()


    val history = liveData(Dispatchers.Default) {
        emitSource(iHistoryRepo.getAllUserDetails())
    }

}


