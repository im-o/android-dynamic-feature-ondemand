package id.rivaldy.core.data.datasource.remote

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import retrofit2.http.*

/** Created by github.com/im-o on 6/22/2023. */

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UserResponse

    @GET("users/{username}")
    suspend fun getDetailUser(
        @Path("username") username: String
    ): UserDetailResponse
}