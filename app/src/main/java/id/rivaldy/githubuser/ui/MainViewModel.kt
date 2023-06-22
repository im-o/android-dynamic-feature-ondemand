package id.rivaldy.githubuser.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rivaldy.core.data.UiState
import id.rivaldy.core.data.model.user.UserResponse
import id.rivaldy.core.domain.usecase.user.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _uiStateUser: MutableLiveData<UiState<UserResponse>> = MutableLiveData()
    val uiStateUser: LiveData<UiState<UserResponse>> get() = _uiStateUser

    fun getUsersApiCall() {
        viewModelScope.launch {
            getUsersUseCase.execute(Unit)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _uiStateUser.value = UiState.Error(e.message.toString())
                }
                .collect { user ->
                    _uiStateUser.value = UiState.Success(user)
                }
        }
    }
}