val releaseGroup: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

application.mainClass.set("$releaseGroup.app.App")

ktlint.version.set(libs.versions.ktlint.get())

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}
