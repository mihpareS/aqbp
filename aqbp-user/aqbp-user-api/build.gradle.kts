dependencies {
    implementation(project(":aqbp-common"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    compileOnly("org.projectlombok:lombok")

    annotationProcessor("org.projectlombok:lombok")

    implementation("cn.hutool:hutool-core")

    implementation("cn.hutool:hutool-crypto")
}