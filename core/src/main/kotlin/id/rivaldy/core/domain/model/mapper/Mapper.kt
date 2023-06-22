package id.rivaldy.core.domain.model.mapper

import id.rivaldy.core.data.model.detailuser.UserDetailResponse
import id.rivaldy.core.data.model.user.UserItem
import id.rivaldy.core.domain.model.User
import id.rivaldy.core.domain.model.UserDetail

/** Created by github.com/im-o on 6/22/2023. */

object UserMapper {
    fun fromRemote(user: UserItem): User {
        return User(user.id, user.login, user.type, user.avatarUrl)
    }
}

object UserDetailMapper {
    fun fromRemote(user: UserDetailResponse): UserDetail {
        return UserDetail(user.id, user.login, user.type, user.avatarUrl, user.name, user.email, user.location, user.bio, user.followers, user.following)
    }
}