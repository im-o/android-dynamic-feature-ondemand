package id.rivaldy.githubuser.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.findNavController
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import id.rivaldy.githubuser.R
import id.rivaldy.githubuser.databinding.FragmentMainBinding

/** Created by github.com/im-o on 6/22/2023. */

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var manager: SplitInstallManager
    private var packageNameModule = ""
    private var dynamicModuleClassName = ""
    private var isModuleAdminInstalled = false

    private val listener = SplitInstallStateUpdatedListener { state ->
        val multiInstall = state.moduleNames().size > 1
        val name = state.moduleNames().joinToString(" - ")
        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                toastLog("DOWNLOADING $name")
                //updateLoadingState(state, "Downloading $name")
            }

            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                toastLog("REQUIRES_USER_CONFIRMATION")
            }

            SplitInstallSessionStatus.INSTALLED -> {
                toastLog("INSTALLED")
                initListener()
                //binding.loadingPB.isVisible = false
//                if (progressDialog.isShowing) {
//                    showAlertDialog("Another feature successfully installed")
//                    progressDialog.dismiss()
//                    progressDialog.progress = 0
//                    progressDialog.max = 100
//                }
            }

            SplitInstallSessionStatus.INSTALLING -> {
                toastLog("INSTALLING $name")
                //updateLoadingState(state, "Installing $name")
            }

            SplitInstallSessionStatus.FAILED -> {
                toastLog("FAILED")
                //showAlertDialog("Another feature failed installed")
//                progressDialog.dismiss()
            }

            SplitInstallSessionStatus.CANCELING -> {
                toastLog("CANCELING")
            }

            SplitInstallSessionStatus.CANCELED -> {
                toastLog("CANCELED")
            }

            SplitInstallSessionStatus.DOWNLOADED -> {
                toastLog("DOWNLOADED")
            }

            SplitInstallSessionStatus.PENDING -> {
                toastLog("PENDING")
            }

            SplitInstallSessionStatus.UNKNOWN -> {
                toastLog("UNKNOWN")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        manager = SplitInstallManagerFactory.create(requireContext())
//        packageNameModule = requireActivity().packageName
//        initListener()
        initView()
    }

    private fun initView() {
        binding.testTV.setOnClickListener {
            val navController = findNavController()
            val installMonitor = DynamicInstallMonitor()

            navController.navigate(
                R.id.navigateToDetailFeature,
                null,
                null,
                DynamicExtras(installMonitor)
            )

            if (installMonitor.isInstallRequired) {
                installMonitor.status.observe(viewLifecycleOwner, Observer { sessionState ->
                    when (sessionState.status()) {
                        SplitInstallSessionStatus.INSTALLED -> {
                            // Call navigate again here or after the user taps again in the UI:
                            navController.navigate(R.id.navigateToDetailFeature, null, null, null)
                            Log.e("ERROR-VAL", "initView: INSTALLED")
                        }

                        SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                            SplitInstallManagerFactory.create(requireContext())
                                .startConfirmationDialogForResult(
                                    sessionState,
                                    requireActivity(),
                                    REQUEST_CODE_CONFIRMATION
                                )
                            Log.e("ERROR-VAL", "initView: REQUIRES_USER_CONFIRMATION")
                        }
                        // Handle all remaining states:
                        SplitInstallSessionStatus.FAILED -> {
                            Log.e("ERROR-VAL", "initView: FAILED")
                        }

                        SplitInstallSessionStatus.CANCELED -> {
                            Log.e("ERROR-VAL", "initView: CANCELED")
                        }
                    }

                    if (sessionState.hasTerminalStatus()) {
                        Log.e("ERROR-VAL", "initView: ER")
                        installMonitor.status.removeObservers(viewLifecycleOwner)
                    }
                })
            }
        }
    }

    private fun initListener() {
        manager.installedModules.toList().forEach {
            if (it.equals(MODULE_ADMIN_FEATURE, true)) {
                //binding.adminMB.text = getString(R.string.go_to_admin_feature)
                isModuleAdminInstalled = true
            }
        }
        if (!isModuleAdminInstalled) {
            //binding.adminMB.text = getString(R.string.go_to_admin_disable)
        }
    }

    private fun toastLog(message: String) {
        Log.e("ERROR-VAL", message)
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        initListener()
    }

    companion object {
        const val REQUEST_CODE_CONFIRMATION = 100
        const val MODULE_ADMIN_FEATURE = "feature:detail"
    }
}