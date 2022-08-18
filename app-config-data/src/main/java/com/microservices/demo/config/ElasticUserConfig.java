package com.microservices.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "user-config")
public class ElasticUserConfig {
    private String username;
    private String password;
    private String [] roles;
}
