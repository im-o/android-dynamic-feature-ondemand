package id.rivaldy.core.data.datasource.remote

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

/** Created by github.com/im-o on 6/22/2023. */

interface ApiService {

    @GET("/users")
    fun getUsers(): Observable<List<UserResponse>>

    @GET("/users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): Single<UserDetailResponse>
}