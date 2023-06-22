package id.rivaldy.githubuser.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rivaldy.core.data.UiState
import id.rivaldy.core.domain.model.User
import id.rivaldy.core.domain.model.mapper.UserMapper
import id.rivaldy.core.domain.usecase.user.GetUsersUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _uiStateUsers: MutableLiveData<UiState<List<User>>> = MutableLiveData()
    val uiStateUsers: LiveData<UiState<List<User>>> get() = _uiStateUsers

    fun getUsersApiCall() {
        viewModelScope.launch {
            getUsersUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { users ->
                    users.map { UserMapper.fromRemote(it) }
                }
                .subscribeBy(
                    onNext = { users ->
                        _uiStateUsers.value = UiState.Success(users)
                    },
                    onError = { e ->
                        _uiStateUsers.value = UiState.Error(e.message.toString())
                    }
                )
        }
    }
}