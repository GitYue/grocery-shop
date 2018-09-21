package com.own.grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GroceryApplication {
	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}
}