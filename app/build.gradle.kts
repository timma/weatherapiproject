plugins {
    id(Plugins.ANDROID_APPLICATION)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = ConfigData.APPLICATION_ID

    compileSdk = ConfigData.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ConfigData.MIN_SDK_VERSION
        targetSdk = ConfigData.TARGET_SDK_VERSION
        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ConfigData.PROGUARD_ANDROID_OPT),
                ConfigData.CONSUMER_PROGUARD
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.NAVIGATION_FRAGMENT)

    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_MATERIAL_3)
    implementation(Dependencies.COMPOSE_PREVIEW)
    implementation(Dependencies.COMPOSE_CONSTRAIN_LAYOUT)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.ACC_SYSTEM_UI)
    implementation(Dependencies.LIFECYCLE_VM_COMPOSE)
    implementation(Dependencies.COMPOSE_LIVEDATA)
    implementation(Dependencies.COMPOSE_UI_TOOLING)

    implementation("androidx.compose.material3:material3:1.1.0-alpha01")

    testImplementation(Dependencies.J_UNIT)
    androidTestImplementation(Dependencies.EXT_J_UNIT)
    androidTestImplementation(Dependencies.UI_TEST_ESPRESSO)
    androidTestImplementation(Dependencies.UI_TEST_COMPOSE)
}