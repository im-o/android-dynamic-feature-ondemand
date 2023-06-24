package id.rivaldy.detail.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap
import id.rivaldy.core.factory.ViewModelFactory
import id.rivaldy.detail.ui.DetailViewModel

/** Created by github.com/im-o on 6/24/2023. */

@Module
@InstallIn(ViewModelComponent::class)
abstract class DetailModuleViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DetailModuleViewModelKey(DetailViewModel::class)
    abstract fun bindTestModuleViewModel(viewModel: DetailViewModel): ViewModel
}