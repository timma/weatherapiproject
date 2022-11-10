object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUN_KTX}"

    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"

    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING}"

    const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"

    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_CONSTRAIN_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:${Versions.CONSTRAIN_LAYOUT_COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val LIFECYCLE_VM_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE_RUN_KTX}"
    const val ACC_SYSTEM_UI = "com.google.accompanist:accompanist-systemuicontroller:${Versions.ACCOMPANIST}"
    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:1.1.0-alpha01"

    //Test
    const val J_UNIT = "junit:junit:${Versions.J_UNIT}"
    const val EXT_J_UNIT = "androidx.test.ext:junit:${Versions.EXT_J_UNIT}"
    const val UI_TEST_ESPRESSO = "androidx.test.espresso:espresso-core::${Versions.UI_ESPRESSO}"
    const val UI_TEST_COMPOSE = "androidx.compose.ui:ui-test-junit4::${Versions.COMPOSE}"
}