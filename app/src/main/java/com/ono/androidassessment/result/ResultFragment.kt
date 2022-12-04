package com.ono.androidassessment.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.ono.androidassessment.MainActivityViewModel
import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "ResultFragment"

fun FragmentResultBinding.displayResult(userAgeModel: UserAgeModel) {
    val value = StringBuilder().append("Name : \t").append(userAgeModel.name).append("\n Age : \t").append(userAgeModel.age).toString()
    tvResult.text = value
}

@AndroidEntryPoint
class ResultFragment : Fragment() {

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var binding: FragmentResultBinding
    private val viewModel: ResultViewModel by viewModels()
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    val args: ResultFragmentArgs by navArgs()

    private val saveClickListener by lazy {
        View.OnClickListener {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.resultViewModel = viewModel
        binding.saveClickListener = saveClickListener

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainActivityViewModel.queryText.collect {
                    if (it.isNotEmpty()) {
                        viewModel._userName.value = it
                    } else {
                        args.username?.let { argName ->
                            if (argName.isNotEmpty() && argName != "") {
                                viewModel._userName.value = argName
                            }
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userDetail.collect {
//                    CoroutineScope(Dispatchers.Default).launch {
//                        DatabaseEngine.getInstance(requireActivity()).userDao().insertNewDetail(it)
//                    }

                    withContext(Dispatchers.Main) {
                        binding.displayResult(it as UserAgeModel)
                    }
                }
            }
        }

        return binding.root
    }

}