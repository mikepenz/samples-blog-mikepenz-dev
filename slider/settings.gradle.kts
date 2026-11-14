rootProject.name = "slider"
pluginManagement { repositories { gradlePluginPortal(); mavenCentral(); google() } }
dependencyResolutionManagement {
    repositories { mavenCentral(); google() }
    // Versions come from https://github.com/mikepenz/convention (same pattern as the owner's other projects).
    versionCatalogs { create("baseLibs") { from("com.mikepenz:version-catalog:0.23.2") } }
}
