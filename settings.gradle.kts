pluginManagement {
    includeBuild("version-plugin")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("compose") { from(files("version-plugin/toml/compose.versions.toml")) }
        create("app") { from(files("version-plugin/toml/app.versions.toml") ) }
        create("libs") { from(files("version-plugin/toml/libs.versions.toml") ) }
    }
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://gitee.com/ezy/gradle/raw/cosmo")
        }
    }
}

rootProject.name = "AndroidComposeLearn"
include(":app")
 