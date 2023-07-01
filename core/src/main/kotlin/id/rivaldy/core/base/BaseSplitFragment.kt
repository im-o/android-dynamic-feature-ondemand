package id.rivaldy.core.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.play.core.splitcompat.SplitCompat

/** Created by github.com/im-o on 7/2/2023. */

open class BaseSplitFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        SplitCompat.install(context)
    }
}