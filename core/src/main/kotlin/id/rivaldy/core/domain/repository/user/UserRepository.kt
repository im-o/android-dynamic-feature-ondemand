package id.rivaldy.core.domain.repository.user

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import kotlinx.coroutines.flow.Flow

/** Created by github.com/im-o on 6/22/2023. */

interface UserRepository {
    suspend fun getUsersApiCall(): Flow<UserResponse>
    suspend fun getUserDetailApiCall(username: String): Flow<UserDetailResponse>
}