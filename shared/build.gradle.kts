plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.nativeCocoapod)
    alias(libs.plugins.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    kotlin.applyDefaultHierarchyTemplate()

    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../app-ios/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
//        extraSpecAttributes["resources"] =
//            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation(libs.kotlinX.coroutines)
            api(libs.koin.core) // Dependency injection
            api(libs.napier) // Logging

            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(libs.kamel)
            api(libs.ktor.core)
            api(libs.kotlinX.dateTime)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            api(compose.components.resources)
        }

        /*sourceSets["commonTest"].dependencies {
            implementation(libs.kotlin.test)
        }*/

        sourceSets["androidMain"].dependencies {
            api(libs.androidX.core)
            api(libs.appCompat)
            api(libs.compose.activity)
            api(libs.compose.tooling)
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            api(libs.compose.material3)
            api(libs.ktor.android)
        }

//        sourceSets["androidUnitTest"].dependencies {}

        sourceSets["iosMain"].dependencies {
            api(libs.ktor.darwin)
        }

//        sourceSets["iosTest"].dependencies {}

        sourceSets["jvmMain"].dependencies {
        }

//        sourceSets["jvmTest"].dependencies {}
    }
}

android {
    compileSdk = 34
    namespace = "com.company.calendarbooking.android"

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerVersion.get()
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}
