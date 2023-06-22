package id.rivaldy.core.data

/** Created by github.com/im-o on 6/22/2023. */

sealed class UiState<out T : Any?> {

    object Loading : UiState<Nothing>()

    data class Success<out T : Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}