package com.ulises.notificationsserver;

import com.ulises.notificationsserver.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.notificationsserver.rest.exceptionsmappers.NotFoundMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import static com.ulises.notificationsserver.constants.Constants.*;

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

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(EMAIL_HOST);
		mailSender.setPort(EMAIL_PORT);
		mailSender.setUsername(EMAIL_USERNAME);
		mailSender.setPassword(EMAIL_PASSWORD);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
}
