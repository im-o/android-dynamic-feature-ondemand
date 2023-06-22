package id.rivaldy.githubuser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.rivaldy.core.data.UiState
import id.rivaldy.core.util.UtilFunctions.logE
import id.rivaldy.githubuser.databinding.FragmentMainBinding

/** Created by github.com/im-o on 6/22/2023. */

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initObserve()
    }

    private fun initData() {
        viewModel.getUsersApiCall()
    }

    private fun initObserve() {
        viewModel.uiStateUsers.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    logE("UiState.Loading")
                    // Show loading state
                }

                is UiState.Success -> {
                    val users = uiState.data
                    logE("UiState.Success : $users")
                    // Handle successful response and update UI
                }

                is UiState.Error -> {
                    val errorMessage = uiState.errorMessage
                    logE("UiState.Error : $errorMessage")
                    // Handle error state and show error message
                }
            }
        }
    }
}