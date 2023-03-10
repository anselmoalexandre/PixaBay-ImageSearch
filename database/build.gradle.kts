import mz.co.bilheteira.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply {
    from("${rootProject.projectDir}/android_default.gradle")
}

dependencies {

    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.kapt)

    api(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.kapt)

    testImplementation(Dependencies.Test.truth)
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.espresso)
    testImplementation(Dependencies.Test.mockkagent)
    testImplementation(Dependencies.Test.coroutines)
    testImplementation(Dependencies.Test.mockkandroid)
}
