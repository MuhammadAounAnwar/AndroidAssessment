package com.ono.androidassessment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel : ViewModel() {

    var _queryText: MutableStateFlow<String> = MutableStateFlow("")
    val queryText: StateFlow<String> = _queryText

}