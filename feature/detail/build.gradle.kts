import dependencies.MyDependencies

plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "id.rivaldy.detail"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(Modules.app))
    implementation(project(Modules.core))

    // Default Dependencies
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)

    // DI - Hilt
    implementation(MyDependencies.hilt)
    kapt(MyDependencies.hilt_kapt)
}