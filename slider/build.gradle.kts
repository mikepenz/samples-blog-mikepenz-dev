plugins {
    alias(baseLibs.plugins.kotlinMultiplatform)
    alias(baseLibs.plugins.composeCompiler)
    alias(baseLibs.plugins.composeMultiplatform)
}
kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "slider"
        browser { commonWebpackConfig { outputFileName = "slider.js" } }
        binaries.executable()
    }
    sourceSets.wasmJsMain.dependencies {
        implementation(baseLibs.jetbrains.compose.runtime)
        implementation(baseLibs.jetbrains.compose.foundation)
        implementation(baseLibs.jetbrains.compose.material3)
        implementation(baseLibs.jetbrains.compose.ui)
    }
}
