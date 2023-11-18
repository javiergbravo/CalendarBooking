plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
}

android {
    compileSdk = 34
    namespace = "com.jgbravo.calendarbooking"

    defaultConfig {
        applicationId = "com.jgbravo.calendarbooking"
        minSdk = 21
        targetSdk = compileSdk
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_20
        targetCompatibility = JavaVersion.VERSION_20
    }

    kotlin {
        jvmToolchain(20)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    implementation(project(":shared"))
}
