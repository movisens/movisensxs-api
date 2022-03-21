import java.util.regex.Pattern

/*
 * This build file was auto generated by running the Gradle 'init' task
 * by 'Juergen' at '22.06.14 22:50' with Gradle 1.11
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * user guide available at http://gradle.org/docs/1.11/userguide/tutorial_java_projects.html
 */

// Apply the java plugin to add support for Java
plugins {
    id("java")
    id("eclipse")
    id("idea")
    id("maven")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_6
    targetCompatibility = JavaVersion.VERSION_1_6
}
group = "com.github.movisens"
val packageJsonVersionRegex = Pattern.compile("\"version\":").toRegex()
version = rootProject.file("package.json")
    .bufferedReader()
    .readLines()
    .firstOrNull { packageJsonVersionRegex.find(it) != null }
    ?.replace(packageJsonVersionRegex, "")
    ?.replace(Regex("[\",]"), "")
    ?.trim() ?: "1.0.0"

// In this section you declare where to find the dependencies of your project
repositories {
    // Use 'maven central' for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
    jcenter()
    maven(url = "http://oss.sonatype.org/content/repositories/snapshots")
}

// In this section you declare the dependencies for your production and test code
dependencies {
    // The production code
    compile("com.squareup.retrofit2:retrofit:2.6.0")
    compile("com.squareup.retrofit2:converter-gson:2.6.0")
    compile("com.squareup.okhttp3:logging-interceptor:3.4.1")
    compileOnly("org.jetbrains:annotations:17.0.0")

    // Declare the dependency for your favourite test framework you want to use in your tests.
    // TestNG is also supported by the Gradle Test task. Just change the
    // testCompile dependency to testCompile 'org.testng:testng:6.8.1' and add
    // "test.useTestNG()' to your build script.
    testCompile("junit:junit:4.11")
    testCompile("com.jayway.awaitility:awaitility:1.7.0")
    testCompile("commons-io:commons-io:2.6")
}