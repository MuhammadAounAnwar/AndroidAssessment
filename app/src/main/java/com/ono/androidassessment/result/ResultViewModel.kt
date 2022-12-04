package com.ono.androidassessment.result

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor() : ViewModel() {

//    private val repo by lazy {
//        RepositoryImpl()
//    }

    @Inject
    lateinit var repo: IRepository

    var _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    val userDetail = userName.transformLatest { name ->
        if (name != "") {
            emit(repo.getUserAge(name))
        }
    }.shareIn(
        ProcessLifecycleOwner.get().lifecycleScope, SharingStarted.WhileSubscribed(), 1
    ).distinctUntilChanged()

}