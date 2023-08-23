pluginManagement {
  listOf(repositories, dependencyResolutionManagement.repositories).forEach {
    it.apply {
      gradlePluginPortal()
      mavenCentral()
      google()
      mavenLocal()
    }
  }
}