package id.rivaldy.core.di

import dagger.Provides
import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.repository.UserRepositoryImpl
import id.rivaldy.core.domain.repository.user.UserRepository
import javax.inject.Singleton

/** Created by github.com/im-o on 6/22/2023. */

object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }
}