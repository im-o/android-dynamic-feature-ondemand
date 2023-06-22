package id.rivaldy.core.util

import android.content.Context
import android.widget.Toast

/** Created by github.com/im-o on 6/22/2023. */

object Extensions {
    fun Context.myToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}