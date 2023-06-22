package id.rivaldy.core.domain.repository.user

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import io.reactivex.Observable
import io.reactivex.Single

/** Created by github.com/im-o on 6/22/2023. */

interface UserRepository {
    fun getUsersApiCall(): Observable<List<UserResponse>>
    suspend fun getUserDetailApiCall(username: String): Single<UserDetailResponse>
}