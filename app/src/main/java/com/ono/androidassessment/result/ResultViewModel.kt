package com.ono.androidassessment.result

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.*

class ResultViewModel : ViewModel() {

    private val repo by lazy {
        RepositoryImpl()
    }

    var _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    val userDetail = userName.transformLatest { name ->
        if (name != "") {
            emit(repo.getUserAge(name))
        }
    }.shareIn(
        ProcessLifecycleOwner.get().lifecycleScope,
        SharingStarted.WhileSubscribed(),
        1
    ).distinctUntilChanged()

}