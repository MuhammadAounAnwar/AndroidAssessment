package com.ono.androidassessment.history

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import com.ono.androidassessment.ViewModelInjector
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class HistoryVMInjector @Inject constructor(private val context: Application, private val iHistoryRepo: IHistoryRepo) : ViewModelInjector<HistoryViewModel> {
    override fun create(savedStateHandle: SavedStateHandle): HistoryViewModel = HistoryViewModel(iHistoryRepo)
}