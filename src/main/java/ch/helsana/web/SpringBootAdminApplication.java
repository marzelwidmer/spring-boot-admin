package ch.helsana.web;

import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.discovery.ApplicationDiscoveryListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

import javax.annotation.PostConstruct;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableGlobalAuthentication
public class SpringBootAdminApplication {

	@Autowired
	private ApplicationDiscoveryListener listener;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// we have to fire this event in order to trigger the service registration
		InstanceRegisteredEvent<?> event = new InstanceRegisteredEvent<>("prod", null);
		// for some reason publising doesn't work, so we invoke directly
		listener.onInstanceRegistered(event);
	}}
