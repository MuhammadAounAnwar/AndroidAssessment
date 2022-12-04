package com.ono.androidassessment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ono.androidassessment.ViewModelFactory
import com.ono.androidassessment.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    private lateinit var binding: FragmentHistoryBinding

    private val injector by lazy {
        HistoryVMInjector(requireContext())
    }

    private val viewModel by lazy {
        val factory = ViewModelFactory(injector, this, null)
        ViewModelProvider(this, factory)[HistoryViewModel::class.java]
    }

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

