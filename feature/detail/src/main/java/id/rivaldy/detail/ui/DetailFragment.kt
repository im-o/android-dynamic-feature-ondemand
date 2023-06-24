package id.rivaldy.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import id.rivaldy.core.domain.model.UserDetail
import id.rivaldy.core.util.Extensions.myToast
import id.rivaldy.detail.databinding.FragmentDetailBinding

/** Created by github.com/im-o on 6/22/2023. */

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var usernameExtra: String = ""
    private val args: DetailFragmentArgs by navArgs()
    //private val viewModel by viewModels<SampleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usernameExtra = args.username ?: ""
        requireContext().myToast("usernameExtra : ($usernameExtra)")
        initData()
        initObserve()
    }

    private fun initData() {
        //viewModel.getUserDetailApiCall(usernameExtra)
    }

    private fun initObserve() {
//        viewModel.uiStateUserDetail.observe(viewLifecycleOwner) { uiState ->
//            when (uiState) {
//                is UiState.Loading -> {
//                    isLoadData(true)
//                }
//
//                is UiState.Success -> {
//                    UtilFunctions.logE(uiState.data.toString())
//                    showUserDetail(uiState.data)
//                }
//
//                is UiState.Error -> {
//                    val errorMessage = uiState.errorMessage
//                    requireContext().myToast(errorMessage)
//                    showUserDetail()
//                }
//            }
//        }
    }

    private fun showUserDetail(item: UserDetail? = null) {
        isLoadData(false)
        if (item != null) {
            val name = "${item.name} (${item.username})"
            val info1 = "Followers (${item.followers}) • Following (${item.following})"
            val info2 = "Email (${item.email ?: "-"}) • Type (${item.type})"
            val info3 = "Location (${item.location ?: "-"})"
            binding.apply {
                userNameTV.text = name
                info1TV.text = info1
                info2TV.text = info2
                info3TV.text = info3
                descriptionTV.text = item.bio ?: "-"
                Glide.with(root.context)
                    .load(item.avatarUrl)
                    .placeholder(android.R.color.darker_gray)
                    .into(imageIV)
            }
        }
    }

    private fun isLoadData(isLoadData: Boolean) {
        binding.progressBar.isVisible = isLoadData
    }
}