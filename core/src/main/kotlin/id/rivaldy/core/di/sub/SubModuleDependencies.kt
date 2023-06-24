package id.rivaldy.core.di.sub

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rivaldy.core.domain.usecase.user.GetUserDetailUseCase

/** Created by github.com/im-o on 6/24/2023. */

@EntryPoint
@InstallIn(SingletonComponent::class)
interface SubModuleDependencies {
    fun provideGetUserDetailUseCase(): GetUserDetailUseCase
}