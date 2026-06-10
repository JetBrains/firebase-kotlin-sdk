dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        val kotlin_repo_url: String? by settings
        val kotlin_version: String? by settings
        val repoUrl = kotlin_repo_url
        val kotlinVersion = kotlin_version
        if (!repoUrl.isNullOrEmpty() && !kotlinVersion.isNullOrEmpty()) {
            exclusiveContent {
                forRepository {
                    maven(repoUrl)
                }
                filter {
                    includeVersionByRegex("org.jetbrains.kotlin.*", ".*", kotlinVersion)
                }
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
