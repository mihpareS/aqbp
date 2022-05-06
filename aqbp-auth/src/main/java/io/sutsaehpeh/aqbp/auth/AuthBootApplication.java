package io.sutsaehpeh.aqbp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthBootApplication.class, args);
    }
}
