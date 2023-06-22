package id.rivaldy.core.domain.usecase.user

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import id.rivaldy.core.domain.usecase.BaseUseCaseSuspend
import io.reactivex.Single
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

class GetUserDetailUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCaseSuspend<String, Single<UserDetailResponse>>() {
    override suspend fun execute(params: String): Single<UserDetailResponse> {
        return repository.getUserDetailApiCall(params)
    }
}