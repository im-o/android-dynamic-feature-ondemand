package id.rivaldy.core.domain.model

/** Created by github.com/im-o on 6/22/2023. */

data class UserDetail(
    val id: Int? = null,
    val username: String? = null,
    val type: String? = null,
    val avatarUrl: String? = null,
    val name: String? = null,
    val email: String? = null,
    val location: String? = null,
    val bio: String? = null,
    val followers: Int? = null,
    val following: Int? = null,
)
