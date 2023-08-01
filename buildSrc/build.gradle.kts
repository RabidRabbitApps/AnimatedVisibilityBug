plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.0.2")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.45")
    implementation(kotlin(module = "gradle-plugin", version = "1.8.10"))
}
