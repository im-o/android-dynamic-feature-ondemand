package id.rivaldy.githubuser

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.play.core.splitcompat.SplitCompat
import dagger.hilt.android.HiltAndroidApp

/** Created by github.com/im-o on 6/22/2023. */

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}