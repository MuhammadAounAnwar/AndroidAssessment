package com.ono.androidassessment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

    var _queryText: MutableStateFlow<String> = MutableStateFlow("")
    val queryText: StateFlow<String> = _queryText

}