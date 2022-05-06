plugins {
    id("org.springframework.boot") version "2.3.12.RELEASE"
}

apply(plugin = "org.springframework.boot")

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")
}