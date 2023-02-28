package io.sutsaehpeh.aqbp.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class Oauth2ResourceServerConfig {



    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {



        return http.build();
    }




}
