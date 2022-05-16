plugins {
    id("org.springframework.boot") version "2.3.12.RELEASE"
}

dependencies {

    implementation(project(":aqbp-common"))

    implementation(project(":aqbp-user:aqbp-user-api"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")

    implementation("org.springframework.cloud:spring-cloud-starter-security")

    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    implementation("cn.hutool:hutool-jwt")
}