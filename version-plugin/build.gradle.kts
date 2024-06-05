plugins {
    `kotlin-dsl`
}
gradlePlugin {
    plugins{
        register("AppBuild") {
            id = "app-build"
            implementationClass = "com.crow.plugin.AppPlugin"
        }
    }
}

dependencies {
    implementation(app.android.tools.build.gradle)
    implementation(app.kotlin.gradle.plugin)
}