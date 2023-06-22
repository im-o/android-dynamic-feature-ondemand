package id.rivaldy.core.data.repository

import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/** Created by github.com/im-o on 6/22/2023. */

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override fun getUsersApiCall(): Observable<List<UserResponse>> {
        return apiService.getUsers()
    }

    override fun getUserDetailApiCall(username: String): Single<UserDetailResponse> {
        return apiService.getUserDetail(username)
    }
}