package id.rivaldy.detail.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/** Created by github.com/im-o on 6/24/2023. */

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class DetailModuleViewModelKey(val value: KClass<out ViewModel>)