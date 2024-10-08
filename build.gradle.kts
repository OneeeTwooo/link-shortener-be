plugins {
    id("java-library")
    id("idea")
    id("maven-publish")
    id("org.springframework.boot") version "3.3.4" apply false
    id("io.spring.dependency-management") version "1.1.6" apply true
}

group = "by.vasileuski.link-shortener"
version = "1.0"

subprojects {
    task("info") {
        doLast {
            println("project.version=${project.version}; project.group=${project.group}; project.name=${project.name}")
        }
    }

    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "idea")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.getByName<Jar>("jar") {
        enabled = true
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }

    rootProject.extra.set("springBootVersion", "3.3.4")
    rootProject.extra.set("lombokVersion", "1.18.34")
    rootProject.extra.set("commonsLang", "3.17.0")

    rootProject.extra.set("springBootStarterTest", "3.3.4")
    rootProject.extra.set("junit", "4.13.2")
    rootProject.extra.set("mockito", "5.14.1")

    dependencies {
        compileOnly("org.projectlombok:lombok:${rootProject.extra.get("lombokVersion")}")
        annotationProcessor("org.projectlombok:lombok:${rootProject.extra.get("lombokVersion")}")
    }

    buildscript {
        repositories {
            mavenLocal()
            mavenCentral()
            google()
            maven {
                url = uri("https://repo.spring.io/milestone")
            }
        }
    }
}