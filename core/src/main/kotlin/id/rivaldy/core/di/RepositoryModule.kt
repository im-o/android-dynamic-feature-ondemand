package id.rivaldy.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.data.repository.UserRepositoryImpl
import id.rivaldy.core.domain.repository.user.UserRepository

/** Created by github.com/im-o on 6/22/2023. */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }
}