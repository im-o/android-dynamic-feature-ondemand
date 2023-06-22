package id.rivaldy.core.domain.usecase.user

import id.rivaldy.core.data.model.user.UserResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import id.rivaldy.core.domain.usecase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

/** Created by github.com/im-o on 6/22/2023. */

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<Unit, Observable<List<UserResponse>>>() {
    override fun execute(params: Unit): Observable<List<UserResponse>> {
        return repository.getUsersApiCall()
    }
}