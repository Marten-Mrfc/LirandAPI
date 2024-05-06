# Lirand API

**THIS IS A FORK OF THE Lirand API BECAUSE IT WAS OUTDATED!**

**THIS IS NOT 100% TESTED AND MAY CONTAIN BUGS.**\
**PROBABLY CONTAINS MANY THINGS THAT STILL NEED CHANGE MAKE PULL REQUESTS IF YOU WANT TO HELP!**



Lirand API allows you to develop PaperMC plugins faster, easier 
and more Kotlin-like way.

It includes a lot of cool features like:
 - Command DSL builders based on the [Mojang Brigadier](https://github.com/Mojang/brigadier)
 - Three types of inventory-based menus and their DSL builders
 - Easy way to change the NBT of items and entities 
 - Shared event flow
 - Items and inventories serialization/deserialization
 - Online player collections
 - A bunch of useful extensions for working with chat, events, items, inventories, etc.
 - Scoreboard builder (experimental)


## Declaring a dependency via Gradle
Requires java version: 21
Add the following to your build script:
```kotlin
repositories { 
    // ...
    mavenCentral()
    maven("https://javadoc.jitpack.io")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://libraries.minecraft.net")
    // ...
}

dependencies {
    // ... 
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk9:1.6.0")
    implementation("com.github.marten-mrfc:LirandAPI:VERSION")
    compileOnly("com.mojang:brigadier:1.0.18")
    // ...
}
```
Replace `VERSION` with the version of Lirand API you need. 
Also you can build the latest snapshot on the [JitPack](https://jitpack.io/#marten-mrfc/LirandAPI) and use it as a dependency.

I highly recommend you to shade this dependency into your Jar file 
as well as some dependencies of Lirand API 
([MCCoroutine](https://github.com/Shynixn/MCCoroutine) and [AnvilGUI](https://github.com/WesJD/AnvilGUI)).
