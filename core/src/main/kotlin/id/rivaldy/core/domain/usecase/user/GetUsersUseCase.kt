package id.rivaldy.core.domain.usecase.user

import id.rivaldy.core.data.model.user.UserResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import id.rivaldy.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCaseSuspend<Unit, Flow<UserResponse>>() {
    override suspend fun execute(params: Unit): Flow<UserResponse> {
        return repository.getUsersApiCall()
    }
}