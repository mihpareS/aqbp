plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
}

val springBootVersion: String = "2.3.12.RELEASE"

val springCloudVersion: String = "Hoxton.SR12"

val druidVersion: String = "1.2.9"

val mysqlVersion: String = "5.1.47"

val lombokVersion: String = "1.18.22"

val hutoolVersion: String = "5.7.22"

val querydslVersion: String = "5.0.0"

val blazeQuerydslExtensionVersion = "1.6.6"

val mapStructVersion: String = "1.4.2.Final"

val springfoxVersion: String = "3.0.0"

val swaggerUIVersion: String = "3.0.0"

val redissonVersion: String = "3.17.1"

subprojects {

    group = "io.sutsaehpeh"

    version = "1.0-SNAPSHOT"

    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")

    repositories {
        maven(url = "https://maven.aliyun.com/repository/public/")

        mavenCentral()

        mavenLocal()
    }

    dependencies {

        if (!project.name.contains("api") && !project.name.contains("common")) {
            implementation("io.springfox:springfox-boot-starter:${springfoxVersion}")

            implementation("io.springfox:springfox-swagger-ui:${swaggerUIVersion}")

            runtimeOnly("mysql:mysql-connector-java:${mysqlVersion}")
        }

        if (project.name.contains("service")) {

            implementation("org.springframework.boot:spring-boot-starter-data-jpa")

            implementation("org.springframework.boot:spring-boot-starter-data-redis")

            // querydsl-core is need because the version of core dependency that
            // querydsl-jpa depends on could be lower than itself due to starter
            // projects.
            // for example:
            //
            // querydsl-jpa:5.00
            //   --- querydsl-core: 4.3.0
            //
            //the situation above will cause error when fetching data
            implementation("com.querydsl:querydsl-core:${querydslVersion}")

            implementation("com.querydsl:querydsl-jpa:${querydslVersion}")

            annotationProcessor("com.querydsl:querydsl-apt:${querydslVersion}:jpa")

            // JPA aggregate functions have broken in Querydsl and won't be fixed
            // use blaze-persistence extension to fix
            implementation("com.blazebit:blaze-persistence-integration-querydsl-expressions:${blazeQuerydslExtensionVersion}")

            implementation("com.blazebit:blaze-persistence-integration-hibernate-5.4:${blazeQuerydslExtensionVersion}")

            annotationProcessor("javax.annotation:javax.annotation-api")

            annotationProcessor("org.springframework.boot:spring-boot-starter-data-jpa")
        }

        if (project.name.contains("common")) {

            implementation("com.querydsl:querydsl-core:${querydslVersion}")

            implementation("com.querydsl:querydsl-jpa:${querydslVersion}")
        }

        implementation("cn.hutool:hutool-core")

        implementation("cn.hutool:hutool-json")

        compileOnly("org.projectlombok:lombok")

        annotationProcessor("org.projectlombok:lombok")

        implementation("org.mapstruct:mapstruct")

        annotationProcessor("org.mapstruct:mapstruct-processor")
    }

    dependencyManagement {
        imports {

            mavenBom("org.springframework.boot:spring-boot-dependencies:${springBootVersion}")

            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")

            mavenBom("cn.hutool:hutool-bom:${hutoolVersion}")
        }

        dependencies{
            dependency("com.alibaba:druid-spring-boot-starter:${druidVersion}")

            dependency("mysql:mysql-connector-java:${mysqlVersion}")

            dependency("org.projectlombok:lombok:${lombokVersion}")

            dependency("org.mapstruct:mapstruct:${mapStructVersion}")

            dependency("org.mapstruct:mapstruct-processor:${mapStructVersion}")

            dependency("io.springfox:springfox-boot-starter:${springfoxVersion}")

            dependency("io.springfox:springfox-swagger-ui:${swaggerUIVersion}")

            dependency("org.redisson:redisson:${redissonVersion}")

        }
    }



    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }

    tasks.getByName<JavaCompile>("compileJava") {
        options.encoding = "UTF-8"
    }


}


