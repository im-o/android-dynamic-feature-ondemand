package id.rivaldy.core.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/** Created by github.com/im-o on 6/23/2023. */

fun <T : Any> getDiffCallback(): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }
}