import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "id.rivaldy.core"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
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

    // Remote
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)

    // Glide
    api(MyDependencies.glide)

    // RxKotlin
    api(MyDependencies.rx_kotlin)

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