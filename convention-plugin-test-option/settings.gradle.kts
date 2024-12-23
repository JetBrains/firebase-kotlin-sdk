dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        val kotlin_repo_url: String? by settings
        kotlin_repo_url?.let { maven(it) }
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
