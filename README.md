# Samples for blog.mikepenz.dev

Live Compose Multiplatform (wasm) samples embedded in posts on [blog.mikepenz.dev](https://blog.mikepenz.dev).
Each top-level folder with a `gradlew` is one sample. A push to `main` builds all of them and publishes
`https://mikepenz.github.io/samples-blog-mikepenz-dev/<sample>/`.

The blog frames a sample only after the reader clicks, in a sandboxed iframe, and accepts no other origin than this site.

## Add a sample

1. Copy `slider/` to a new folder. The name is lowercase letters, digits and dashes.
2. Change `rootProject.name`, `outputModuleName`, `outputFileName` and the script name in `src/wasmJsMain/resources/index.html`.
3. Keep the `Content-Security-Policy` meta tag in `index.html`. Pages cannot send headers, so that tag is the policy.
4. Add the folder to `.github/dependabot.yml`.
5. Push. In Storyblok, set the blok's `src` to the published URL.

Build locally: `cd slider && ./gradlew wasmJsBrowserDistribution`, output in `build/dist/wasmJs/productionExecutable/`.

## Versions

Kotlin, the Compose compiler plugin, Compose Multiplatform and the Compose libraries come from the version catalog
of [mikepenz/convention](https://github.com/mikepenz/convention), declared as `baseLibs` in each sample's `settings.gradle.kts`.
To update, raise the `com.mikepenz:version-catalog` version there, run `./gradlew kotlinWasmUpgradeYarnLock` and commit
`kotlin-js-store/`. Update Gradle with `./gradlew wrapper --gradle-version <v> --gradle-distribution-sha256-sum <sha>` (run it twice).

## Security

- Workflow token has no default permissions. Only the deploy job can write to Pages, and only from `main`.
- Actions are pinned to commit SHAs. The Gradle wrapper jar and distribution checksum are verified. No build caches.
- Pull requests build but never deploy.
- Samples load nothing from other origins and ship no source maps.
