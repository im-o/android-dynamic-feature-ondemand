package id.rivaldy.core.util

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.navigation.NavController

/** Created by github.com/im-o on 6/22/2023. */

object Extensions {

    fun Context.myToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun NavController.safeNavigate(
        @IdRes currentDestinationId: Int,
        @IdRes id: Int,
        args: Bundle? = null
    ) {
        if (currentDestinationId == currentDestination?.id) {
            navigate(id, args)
        }
    }
}