package mz.co.bilheteira.buildsrc

object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0"
        const val activity = "androidx.activity:activity-ktx:1.6.0"

        object Navigation {
            const val core = "androidx.navigation:navigation-fragment-ktx:2.5.2"
            const val ui = "androidx.navigation:navigation-ui-ktx:2.5.2"
        }

        object LiveData {
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        }
    }

    object MaterialDesign {
        const val mdc = "com.google.android.material:material:1.8.0-alpha01"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.7.0"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3"

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
        }
    }

    object Room {
        const val room = "androidx.room:room-ktx:2.4.3"
        const val runtime = "androidx.room:room-runtime:2.4.3"
        const val kapt = "androidx.room:room-compiler:2.4.3"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter = "com.squareup.retrofit2:converter-moshi:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:1.14.0"
        const val adapter = "com.squareup.moshi:moshi-adapters:1.14.0"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:1.14.0"
    }

    object Picasso {
        const val picasso = "com.squareup.picasso:picasso:2.71828"
    }

    object CircleImage {
        const val circleimageview = "de.hdodenhof:circleimageview:3.1.0"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:2.44"
        const val kapt = "com.google.dagger:hilt-android-compiler:2.44"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val core = "androidx.test:core:1.4.0"
        const val truth = "com.google.truth:truth:1.0.1"
        const val hamcrest = "org.hamcrest:hamcrest-all:1.3"
        const val coreTest = "androidx.test.ext:junit:1.1.3"
        const val mockkandroid = "io.mockk:mockk-android:1.12.3"
        const val mockkagent = "io.mockk:mockk-agent-jvm:1.12.3"
        const val roboeletric = "org.robolectric:robolectric:4.3.1"
        const val core_testing = "androidx.arch.core:core-testing:2.1.0"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    }
}