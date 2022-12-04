package com.ono.androidassessment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ono.androidassessment.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    private lateinit var binding: FragmentHistoryBinding

//    private val injector by lazy {
//        HistoryVMInjector(requireContext())
//    }

//    @Inject
//    lateinit var injector: HistoryVMInjector

    //    private val iHistoryRepo by lazy {
//        HistoryRepoImpl(context)
//    }

//    private val viewModel by lazy {
//        val factory = ViewModelFactory(injector, this, null)
//        ViewModelProvider(this, factory)[HistoryViewModel::class.java]
//    }

    private val viewModel: HistoryViewModel by viewModels()

    private val adapter by lazy {
        HistoryRVAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.historyViewModel = viewModel
        binding.rvHistory.adapter = adapter

        return binding.root
    }

}

