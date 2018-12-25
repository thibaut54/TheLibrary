package org.thibaut.thelibrary.webservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.thibaut.thelibrary"})
@EnableJpaRepositories(basePackages = {"org.thibaut.thelibrary"})
@EntityScan(basePackages = {"org.thibaut.thelibrary"})
public class Application {

	public static void main(String[] args) {

		SpringApplication.run( Application.class, args );

	}
}
