package com.indus.practice.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.indus.practice.springboot.dao")
@EntityScan("com.indus.practice.springboot.entity")
public class Sb3TierDataLayerNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb3TierDataLayerNewApplication.class, args);
	}

}
