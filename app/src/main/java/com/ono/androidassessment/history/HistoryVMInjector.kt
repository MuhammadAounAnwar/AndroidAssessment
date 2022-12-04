package com.ono.androidassessment.history

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.ono.androidassessment.ViewModelInjector

class HistoryVMInjector(private val context: Context) : ViewModelInjector<HistoryViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): HistoryViewModel = HistoryViewModel(savedStateHandle, context)
}