To reproduce:

```
git clone https://github.com/martinbonnin/test-kotlin-platform-type
cd test-kotlin-platform-type
git checkout d2745e2
cd lib
./gradlew publishToMavenLocal
cd ../app
./gradlew compileKotlinJvm
```

Error:

```
> Task :compileKotlinJvm FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileKotlinJvm'.
> Error while evaluating property 'filteredArgumentsMap' of task ':compileKotlinJvm'.
   > Could not resolve all files for configuration ':jvmCompileClasspath'.
      > Could not resolve com.example:lib:1.0.
        Required by:
            project :
         > No enum constant org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType.wasm
```

Crash is happening [here](https://github.com/gradle/gradle/blob/8afbf24b469158b714b36e84c6f4d4976c86fcd5/subprojects/model-core/src/main/java/org/gradle/internal/snapshot/impl/CoercingStringValueSnapshot.java#L40) because (from what I understand), Gradle tries to coerce the `"wasm"` String value into an enum that doesn't know about it yet.

