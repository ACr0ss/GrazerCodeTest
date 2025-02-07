pluginManagement {
    repositories {

        google()

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

rootProject.name = "GrazerCodeTest"
include(":app")
include(":core:common")
include(":core:network")
include(":core:database")
include(":core:testing")
include(":data")
include(":domain")
include(":features:navigation")
include(":features:login")
include(":features:userlist")
