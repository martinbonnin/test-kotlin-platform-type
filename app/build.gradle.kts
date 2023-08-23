plugins {
  id("org.jetbrains.kotlin.multiplatform").version("1.6.0")
}

kotlin {
  jvm()

  sourceSets {
    getByName("commonMain") {
      dependencies {
        implementation("com.example:lib:1.0")
      }
    }
  }
}

