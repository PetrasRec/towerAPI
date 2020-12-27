package com.example.towerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TowerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TowerApiApplication.class, args);
	}

}
