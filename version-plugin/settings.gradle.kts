dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("compose") { from(files("toml/compose.versions.toml")) }
        create("app") { from(files("toml/app.versions.toml") ) }
        create("libs") { from(files("toml/libs.versions.toml") ) }
    }
    repositories {
//        maven { setUrl("https://maven.aliyun.com/nexus/content/groups/public/") }
//        maven { setUrl("https://maven.aliyun.com/repository/central") }
//        maven { setUrl("https://maven.aliyun.com/repository/google") }
//        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
//        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://jitpack.io") }
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
        google()
    }
}
rootProject.name = "version-plugin"
include (":version-plugin")