package com.ulises.notificationsserver;

import com.ulises.notificationsserver.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.notificationsserver.rest.exceptionsmappers.NotFoundMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsServerApplication.class, args);
	}


	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(NotFoundMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		return resourceConfig;
	}
}
