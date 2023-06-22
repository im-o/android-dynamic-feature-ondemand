package id.rivaldy.core.domain.usecase.user

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import id.rivaldy.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

class GetUserDetailUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCaseSuspend<String, Flow<UserDetailResponse>>() {
    override suspend fun execute(params: String): Flow<UserDetailResponse> {
        return repository.getUserDetailApiCall(params)
    }
}