package com.deretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.deretail.repo")
@SpringBootApplication
public class DeRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeRetailApplication.class, args);
	}

}
