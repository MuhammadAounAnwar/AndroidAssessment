package com.ono.androidassessment.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val iHistoryRepo: IHistoryRepo) : ViewModel() {

    val history = liveData(Dispatchers.Default) {
        emitSource(iHistoryRepo.getAllUserDetails())
    }

}


