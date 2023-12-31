package dependencies

import Versions

/** Created by github.com/im-o on 6/22/2023. */

object MyDependencies {

    // Default Dependencies
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    const val material = "com.google.android.material:material:${Versions.material_version}"
    const val junit = "junit:junit:${Versions.junit_version}"
    const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext_junit_version}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_test_version}"

    // UI
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout_version}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_version}"
    // Navigation
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_ktx_version}"
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_ktx_version}"
    const val navigation_dynamic_features_fragment = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation_ktx_version}"

    // Remote
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofit2_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    const val retrofit2_adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3_version}"

    // ReactiveX RxJava
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid_version}"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin_version}"
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rxjava_version}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

    // Lifecycle KTX
    const val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle_extensions_version}"

    // Activity & Fragment KTX
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_version}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_gradle_plugin}"
    const val hilt_kapt = "com.google.dagger:hilt-compiler:${Versions.hilt_gradle_plugin}"

    // ViewModel with Hilt
    const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_viewModels}"

    // Android Play Core
    const val android_play_core = "com.google.android.play:core:${Versions.android_play_core_version}"
}