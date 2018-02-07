package ch.helsana.microservice.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableGlobalAuthentication
@EnableDiscoveryClient
public class SpringBootAdmin {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdmin.class, args);
    }
}




