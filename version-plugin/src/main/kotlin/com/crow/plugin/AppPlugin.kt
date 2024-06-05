@file:Suppress("ConstPropertyName")

package com.crow.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.crow.CompileSdk
import com.crow.MinSdk
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


class AppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            //配置plugin
            plugins.run {
                apply("com.android.application")
                apply("kotlin-android")
            }
            //配置android
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    minSdk = MinSdk
                    compileSdk = CompileSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                }
            }
        }
    }

    companion object {
        private const val Application = "com.android.application"
        private const val KotlinAndroid = "kotlin-android"
    }
}