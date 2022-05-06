package io.sutsaehpeh.aqbp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayBootApplication.class, args);
    }

}
