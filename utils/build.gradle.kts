import mz.co.bilheteira.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${rootProject.projectDir}/android_default.gradle")
}

dependencies {
    api(Dependencies.Timber.timber)

    implementation(Dependencies.AndroidX.LiveData.liveData)

    testImplementation(Dependencies.Test.junit)
}