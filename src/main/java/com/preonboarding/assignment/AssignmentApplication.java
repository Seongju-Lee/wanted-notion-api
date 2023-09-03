package com.preonboarding.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
			AssignmentApplication.class,
			args);

		DatabaseInitializr initializationService = context.getBean(
			DatabaseInitializr.class);
		initializationService.initializeDatabase();
	}

}
