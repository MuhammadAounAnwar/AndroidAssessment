package com.ono.androidassessment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ono.androidassessment.MainActivityViewModel
import com.ono.androidassessment.R
import com.ono.androidassessment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    private val searchClickListener by lazy {
        View.OnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToResultFragment().setUsername(binding.etName.text.toString().trim())
            findNavController().navigate(action)
        }
    }

    private val historyClickListener by lazy {
        View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.homeViewModel = viewModel
        binding.searchClickListener = searchClickListener
        binding.historyClickListener = historyClickListener

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etName.doOnTextChanged { c, _, _, _ ->
            mainActivityViewModel._queryText.value = c.toString()
        }

    }
}