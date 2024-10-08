apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

version = "1.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra.get("springBootVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra.get("springBootStarterTest")}")
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