pluginManagement {
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
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EffectiveMobileProjectHH"
include(":app")
include(":core-api")
include(":core-data")
include(":feature-auth:login")
include(":feature-auth:register")
include(":core-ui")
include(":feature-main:data")
include(":feature-main:presentation")
include(":feature-main:domain")
include(":core-common")
include(":feature-vacancy-details:data")
include(":feature-vacancy-details:domain")
include(":feature-vacancy-details:presentation")
include(":feature-navigation")
include(":feature-bottom-nav-bar")
