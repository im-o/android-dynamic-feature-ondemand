package id.rivaldy.detail.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.rivaldy.core.di.sub.SubModuleDependencies
import id.rivaldy.detail.ui.DetailFragment
import javax.inject.Singleton

/** Created by github.com/im-o on 6/24/2023. */

@Component(
    dependencies = [SubModuleDependencies::class],
    modules = [DetailModuleViewModelModule::class]
)

@Singleton
interface DetailModuleComponent {
    fun inject(fragment: DetailFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun dependencies(component: SubModuleDependencies): Builder
        fun build(): DetailModuleComponent
    }
}