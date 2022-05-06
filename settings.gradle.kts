pluginManagement {
    repositories {
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")

        gradlePluginPortal()
    }
}
rootProject.name = "aqbp"
include(":aqbp-common")
include(":aqbp-auth")
include(":aqbp-gateway")
include(":aqbp-user:aqbp-user-api")
include(":aqbp-user:aqbp-user-service")
include(":aqbp-api")
