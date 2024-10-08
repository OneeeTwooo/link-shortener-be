apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

version = "1.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra.get("springBootVersion")}")
    implementation("org.apache.commons:commons-lang3:${rootProject.extra.get("commonsLang")}")

    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra.get("springBootStarterTest")}")
    testImplementation("org.mockito:mockito-core:${rootProject.extra.get("mockito")}")
    testImplementation("junit:junit:${rootProject.extra.get("junit")}")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    archiveFileName = "link-shortener.jar"
}