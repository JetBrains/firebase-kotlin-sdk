include(
    "firebase-analytics",
    "firebase-app",
    "firebase-auth",
    "firebase-common",
    "firebase-common-internal",
    "firebase-config",
    "firebase-crashlytics",
    "firebase-database",
    "firebase-firestore",
    "firebase-functions",
    "firebase-installations",
    "firebase-messaging",
    "firebase-perf",
    "firebase-storage",
    "test-utils"
)

pluginManagement {
    includeBuild("convention-plugin-test-option")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://plugins.gradle.org/m2/") }

        val kotlin_repo_url: String? by settings
        kotlin_repo_url?.let { maven(it) }
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        val kotlin_repo_url: String? by settings
        kotlin_repo_url?.let { maven(it) }

        mavenLocal()
    }

    versionCatalogs {
        create("libs") {
            val kotlin_version: String? by settings
            if (kotlin_version != null) {
                version("kotlin", kotlin_version)
            }

            val kotlin_language_version: String? by settings
            if (kotlin_language_version != null) {
                version("settings-language", kotlin_language_version)
            }

            val kotlin_api_version: String? by settings
            if (kotlin_api_version != null) {
                version("settings-api", kotlin_api_version)
            }
        }
    }
}