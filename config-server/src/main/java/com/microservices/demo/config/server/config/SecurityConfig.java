package com.microservices.demo.config.server.config;


import org.springframework.boot.actuate.autoconfigure.cloudfoundry.servlet.CloudFoundryActuatorAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig extends WebSecurityEnablerConfiguration {


}
