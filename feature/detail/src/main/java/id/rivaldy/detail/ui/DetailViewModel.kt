package id.rivaldy.detail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.rivaldy.core.data.UiState
import id.rivaldy.core.domain.model.UserDetail
import id.rivaldy.core.domain.model.mapper.UserDetailMapper
import id.rivaldy.core.domain.usecase.user.GetUserDetailUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

class DetailViewModel @Inject constructor(
    private val getUserDetailUseCase: GetUserDetailUseCase,
) : ViewModel() {

    private val _uiStateUserDetail: MutableLiveData<UiState<UserDetail>> = MutableLiveData()
    val uiStateUserDetail: LiveData<UiState<UserDetail>> get() = _uiStateUserDetail

    fun getUserDetailApiCall(username: String) {
        viewModelScope.launch {
            getUserDetailUseCase.execute(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { user ->
                    UserDetailMapper.fromRemote(user)
                }
                .subscribeBy(
                    onSuccess = { user ->
                        _uiStateUserDetail.value = UiState.Success(user)
                    },
                    onError = { e ->
                        _uiStateUserDetail.value = UiState.Error(e.message.toString())
                    }
                )
        }
    }
}