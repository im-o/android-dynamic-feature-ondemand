package id.rivaldy.core.data.repository

import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import id.rivaldy.core.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

/** Created by github.com/im-o on 6/22/2023. */

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun getUsersApiCall(): Flow<UserResponse> {
        return flowOf(apiService.getUsers())
    }

    override suspend fun getUserDetailApiCall(username: String): Flow<UserDetailResponse> {
        return flowOf(apiService.getUserDetail(username))
    }
}