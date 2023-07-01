package id.rivaldy.githubuser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import dagger.hilt.android.AndroidEntryPoint
import id.rivaldy.core.data.UiState
import id.rivaldy.core.domain.model.User
import id.rivaldy.core.util.Extensions.myToast
import id.rivaldy.core.util.UtilConstants.STR_USERNAME
import id.rivaldy.core.util.UtilConstants.ZERO_DATA
import id.rivaldy.core.util.UtilFunctions.logE
import id.rivaldy.githubuser.R
import id.rivaldy.githubuser.databinding.FragmentMainBinding

/** Created by github.com/im-o on 6/22/2023. */

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainAdapter by lazy { MainAdapter { mainAdapterClick(it) } }
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var navController: NavController
    private val installMonitor = DynamicInstallMonitor()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(binding.root)
        binding.listDataRV.adapter = mainAdapter
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
                    isLoadData(true)
                }

                is UiState.Success -> {
                    logE(uiState.data.toString())
                    showUsers(uiState.data)
                }

                is UiState.Error -> {
                    val errorMessage = uiState.errorMessage
                    requireContext().myToast(errorMessage)
                    showUsers()
                }
            }
        }
    }

    private fun isLoadData(isLoadData: Boolean) {
        binding.progressBar.isVisible = isLoadData
    }

    private fun showUsers(users: List<User> = mutableListOf()) {
        isLoadData(false)
        mainAdapter.submitList(users)
        binding.noDataTV.isVisible = users.size == ZERO_DATA
    }

    private fun mainAdapterClick(item: User) {
        navigateToDetailModule(item.username ?: "")
    }

    private fun navigateToDetailNavGraph(bundle: Bundle) {
        navController.navigate(
            R.id.navigateToDetailNavGraph,
            bundle,
            null,
            DynamicExtras(installMonitor)
        )
    }

    private fun navigateToDetailModule(username: String) {
        val bundle = Bundle().apply {
            putString(STR_USERNAME, username)
        }
        navigateToDetailNavGraph(bundle)
        if (installMonitor.isInstallRequired) {
            installMonitor.status.observe(viewLifecycleOwner) { sessionState ->
                when (sessionState.status()) {
                    SplitInstallSessionStatus.INSTALLED -> {
                        // call again if feature complete installed
                        navigateToDetailNavGraph(bundle)
                    }

                    SplitInstallSessionStatus.DOWNLOADING -> {
                        requireContext().myToast("Download the new feature...")
                    }

                    SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                        SplitInstallManagerFactory.create(requireContext())
                            .startConfirmationDialogForResult(
                                sessionState, requireActivity(), REQUIRES_USER_CONFIRMATION_CODE
                            )
                        logE("Installation need permission")
                    }

                    SplitInstallSessionStatus.FAILED -> {
                        requireContext().myToast("Installation failed")
                    }

                    SplitInstallSessionStatus.CANCELED -> {
                        logE("Installation canceled")
                    }

                    else -> logE("Some other status : ${sessionState.status()}")
                }

                if (sessionState.hasTerminalStatus()) {
                    installMonitor.status.removeObservers(viewLifecycleOwner)
                    logE("Session state has terminal status")
                }
            }
        }
    }

    companion object {
        const val REQUIRES_USER_CONFIRMATION_CODE = 100
    }
}