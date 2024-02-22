package com.indus.practice.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.indus.practice.springboot.svc", "com.indus.practice.springboot.dao", "com.indus.practice.springboot.entity"})
public class Sb3TierServiceLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb3TierServiceLayerApplication.class, args);
	}

}
