package id.rivaldy.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rivaldy.core.domain.repository.user.UserRepository
import id.rivaldy.core.domain.usecase.user.GetUserDetailUseCase
import id.rivaldy.core.domain.usecase.user.GetUsersUseCase

/** Created by github.com/im-o on 6/22/2023. */

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

    @Provides
    fun provideGetUserDetailUseCase(repository: UserRepository): GetUserDetailUseCase {
        return GetUserDetailUseCase(repository)
    }
}