import mz.co.bilheteira.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${rootProject.projectDir}/android_default.gradle")
}

dependencies {
    implementation(Dependencies.AndroidX.LiveData.liveData)
    implementation(Dependencies.Timber.timber)

    testImplementation(Dependencies.Test.junit)
}