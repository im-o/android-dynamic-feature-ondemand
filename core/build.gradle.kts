import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    // Default Dependencies
    api(MyDependencies.core_ktx)
    api(MyDependencies.appcompat)
    api(MyDependencies.material)
    api(MyDependencies.constraint_layout)
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)

    // UI
    api(MyDependencies.swiperefreshlayout)
    api(MyDependencies.navigation_ui_ktx)
    api(MyDependencies.navigation_fragment_ktx)
    api(MyDependencies.navigation_dynamic_features_fragment)

    // Remote
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)
    api(MyDependencies.okhttp3)

    // Glide
    api(MyDependencies.glide)

    // ReactiveX RxJava
    api(MyDependencies.rx_android)
    api(MyDependencies.rx_kotlin)
    api(MyDependencies.rx_java)

    // Lifecycle KTX
    api(MyDependencies.lifecycle_extensions)

    // Activity & Fragment KTX
    api(MyDependencies.fragment_ktx)
    api(MyDependencies.activity_ktx)

    // DI - Hilt
    implementation(MyDependencies.hilt)
    kapt(MyDependencies.hilt_kapt)

    // ViewModel with Hilt
    api(MyDependencies.hilt_viewmodel)
}