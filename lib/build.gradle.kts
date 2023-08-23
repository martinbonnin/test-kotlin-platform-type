import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
  id("org.jetbrains.kotlin.multiplatform").version("1.9.0")
  id("maven-publish")
}

group = "com.example"
version = "1.0"

kotlin {
  coreLibrariesVersion = "1.7.21"

  jvm {
    compilations.all {
      kotlinOptions {
        apiVersion = "1.7"
        languageVersion = "1.7"
      }
    }
  }

  wasm {
    nodejs()
  }
}
